package umg.principal.sistematurno.DTO;

import java.util.ArrayList;
import java.util.List;

public class ServicioDTO {
    private String nombre;
    private List<ServicioDTO> subcategorias = new ArrayList<>();

    public ServicioDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<ServicioDTO> getSubcategorias() {
        return subcategorias;
    }

    public void agregarSubcategoria(ServicioDTO sub) {
        subcategorias.add(sub);
    }
}
