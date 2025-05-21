package umg.principal.sistematurno.Service;

import umg.principal.sistematurno.Structure.ColaTurnos;
import umg.principal.sistematurno.Structure.HistorialLista;
import umg.principal.sistematurno.Model.Turno;
import umg.principal.sistematurno.Model.Historial;

import java.time.LocalDateTime;

public class ServiceTurno {
    private final ColaTurnos cola;
    private final HistorialLista historial;

    public ServiceTurno() {
        this.cola = new ColaTurnos();
        this.historial = new HistorialLista();
    }

    public void crearTurno(Turno turno) {
        cola.agregarTurno(turno);
    }

    public void atenderTurno() {
        Turno turno = cola.obtenerSiguienteTurno();
        if (turno != null) {
            Historial h = new Historial();
            h.setTurno (turno);
            h.setFechaAtencion(LocalDateTime.now());
            historial.agregarRegistro(h);
        }
    }

    public void verEstado() {
        System.out.println("Turnos en espera: " + cola.tamaño());
        System.out.println("Historial de atención: " + historial.tamaño());
    }
}