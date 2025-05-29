package umg.principal.sistematurno.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.principal.sistematurno.Model.Turno;
import umg.principal.sistematurno.Service.ServiceTurno;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private ServiceTurno serviceTurno;

    @PostMapping
    public Turno crearTarea(@RequestBody Turno turno) {
        return serviceTurno.crearTurno(turno);
    }

    @PutMapping("/{id}")
    public Turno actualizarTarea(@PathVariable Long id, @RequestBody Turno turno) {
        return serviceTurno.actualizarTurno(id, turno);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        serviceTurno.eliminarTurno(id);
    }

    @GetMapping
    public List<Turno> listarTareas() {
        return serviceTurno.listarTurnos();
    }
}