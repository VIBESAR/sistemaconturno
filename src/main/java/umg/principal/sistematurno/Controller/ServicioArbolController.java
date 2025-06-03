package umg.principal.sistematurno.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umg.principal.sistematurno.DTO.ServicioDTO;

@RestController
@RequestMapping("/servicios/arbol")
public class ServicioArbolController {

    @GetMapping("/demo")
    public ServicioDTO obtenerArbolDemo() {
        ServicioDTO raiz = new ServicioDTO("Salud");

        ServicioDTO odontologia = new ServicioDTO("Odontología");
        odontologia.agregarSubcategoria(new ServicioDTO("Limpieza Dental"));
        odontologia.agregarSubcategoria(new ServicioDTO("Extracción"));

        ServicioDTO medicina = new ServicioDTO("Medicina General");
        medicina.agregarSubcategoria(new ServicioDTO("Consulta General"));

        raiz.agregarSubcategoria(odontologia);
        raiz.agregarSubcategoria(medicina);

        return raiz;
    }
}
