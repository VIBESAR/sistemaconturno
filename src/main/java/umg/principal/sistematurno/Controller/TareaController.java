package umg.principal.sistematurno.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.principal.sistematurno.Model.Turno;
import umg.principal.sistematurno.Model.Accion;
import umg.principal.sistematurno.Service.ServiceTurno;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private ServiceTurno serviceTurno;

    // POST /tareas
    @PostMapping
    public Turno crearTarea(@RequestBody Turno turno) {
        return serviceTurno.crearTurno(turno);
    }

    // PUT /tareas/{id}
    @PutMapping("/{id}")
    public Turno actualizarTarea(@PathVariable Long id, @RequestBody Turno turno) {
        return serviceTurno.actualizarTurno(id, turno);
    }

    // DELETE /tareas/{id}
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        serviceTurno.eliminarTurno(id);
    }

    // GET /tareas
    @GetMapping
    public List<Turno> listarTareas() {
        return serviceTurno.listarTurnos();
    }

    // GET /tareas/acciones - Ver historial de acciones
    @GetMapping("/acciones")
    public List<Accion> verHistorialAcciones() {
        return serviceTurno.getPilaAcciones().getHistorial();
    }

    // POST /tareas/acciones/deshacer - Deshacer última acción
    @PostMapping("/acciones/deshacer")
    public String deshacerUltimaAccion() {
        Accion ultima = serviceTurno.getPilaAcciones().deshacerUltimaAccion();
        if (ultima == null) {
            return "❌ No hay acciones para deshacer.";
        }

        switch (ultima.getTipo()) {
            case "crear":
                serviceTurno.eliminarTurno(ultima.getTurno().getId());
                return "↩️ Acción revertida: se eliminó el turno creado.";
            case "editar":
                return "🔁 Acción de edición deshecha (simulada).";
            case "eliminar":
                serviceTurno.crearTurno(ultima.getTurno());
                return "♻️ Acción revertida: turno restaurado.";
            default:
                return "⚠️ Acción no reconocida.";
        }
    }

    // GET /tareas/atender - Simula atención del siguiente turno
    @GetMapping("/atender")
    public String atenderTurno() {
        boolean atendido = serviceTurno.atenderTurno();
        return atendido ? "✅ Turno atendido con éxito." : "⚠️ No hay turnos en espera.";
    }
}
