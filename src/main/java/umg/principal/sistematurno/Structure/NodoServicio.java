package umg.principal.sistematurno.Structure;

import java.util.ArrayList;
import java.util.List;

public class NodoServicio {
    private String nombre;
    private List<NodoServicio> subservicios;

    public NodoServicio(String nombre) {
        this.nombre = nombre;
        this.subservicios = new ArrayList<>();
    }

    public void agregarSubservicio(NodoServicio subservicio) {
        subservicios.add(subservicio);
    }

    public String getNombre() {
        return nombre;
    }

    public List<NodoServicio> getSubservicios() {
        return subservicios;
    }

    public void imprimirJerarquia(String prefijo) {
        System.out.println(prefijo + "- " + nombre);
        for (NodoServicio hijo : subservicios) {
            hijo.imprimirJerarquia(prefijo + "  ");
        }
    }
}
