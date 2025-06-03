package umg.principal.sistematurno.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.principal.sistematurno.Model.Accion;
import umg.principal.sistematurno.Model.Historial;
import umg.principal.sistematurno.Model.Turno;
import umg.principal.sistematurno.Repository.HistorialRepository;
import umg.principal.sistematurno.Repository.TurnoRepository;
import umg.principal.sistematurno.Structure.ColaTurnos;
import umg.principal.sistematurno.Structure.HistorialLista;
import umg.principal.sistematurno.Structure.PilaAcciones;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceTurno {

    private final ColaTurnos cola;
    private final HistorialLista historial;
    private final TurnoRepository turnoRepository;
    private final HistorialRepository historialRepository;
    private final TurnoProducer turnoProducer;
    private final PilaAcciones pilaAcciones = new PilaAcciones();

    @Autowired
    private LogMongoService logMongoService; // 👉 inyectado aquí

    @Autowired
    public ServiceTurno(
            TurnoRepository turnoRepository,
            TurnoProducer turnoProducer,
            HistorialRepository historialRepository
    ) {
        this.cola = new ColaTurnos();
        this.historial = new HistorialLista();
        this.turnoRepository = turnoRepository;
        this.turnoProducer = turnoProducer;
        this.historialRepository = historialRepository;
    }

    public Turno crearTurno(Turno turno) {
        if (turno.getFechaCreacion() == null) {
            turno.setFechaCreacion(LocalDateTime.now());
        }

        cola.agregarTurno(turno);
        Turno guardado = turnoRepository.save(turno);
        turnoProducer.enviarTurno(guardado);
        pilaAcciones.registrarAccion(new Accion("crear", guardado));

        logMongoService.log("crear", "Turno creado con ID: " + guardado.getId()); // 👉 log en Mongo

        return guardado;
    }

    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }

    public Turno actualizarTurno(Long id, Turno nuevoTurno) {
        Optional<Turno> op = turnoRepository.findById(id);
        if (op.isPresent()) {
            Turno existente = op.get();
            existente.setDescripcion(nuevoTurno.getDescripcion());
            existente.setCompletada(nuevoTurno.isCompletada());
            existente.setFechaProgramada(nuevoTurno.getFechaProgramada());

            Turno actualizado = turnoRepository.save(existente);
            pilaAcciones.registrarAccion(new Accion("editar", actualizado));
            logMongoService.log("editar", "Turno actualizado con ID: " + actualizado.getId()); // 👉 log
            return actualizado;
        } else {
            throw new RuntimeException("Turno no encontrado con id: " + id);
        }
    }

    public void eliminarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        if (turno.isPresent()) {
            turnoRepository.deleteById(id);
            pilaAcciones.registrarAccion(new Accion("eliminar", turno.get()));
            logMongoService.log("eliminar", "Turno eliminado con ID: " + id); // 👉 log
        } else {
            throw new RuntimeException("Turno no encontrado con id: " + id);
        }
    }

    public boolean atenderTurno() {
        Turno turno = cola.obtenerSiguienteTurno();
        if (turno != null) {
            Historial h = new Historial();
            h.setTurno(turno);
            h.setCliente(turno.getCliente());
            h.setServicio(turno.getServicio());
            h.setFechaAtencion(LocalDateTime.now());
            historial.agregarRegistro(h);
            historialRepository.save(h);
            logMongoService.log("atender", "Turno atendido con ID: " + turno.getId()); // 👉 log
            return true;
        }
        return false;
    }

    public void verEstado() {
        System.out.println("Turnos en espera: " + cola.tamaño());
        System.out.println("Historial de atención: " + historial.tamaño());
    }

    public List<Historial> obtenerHistorialSimulado() {
        return historial.getTodos();
    }

    public PilaAcciones getPilaAcciones() {
        return pilaAcciones;
    }
}

