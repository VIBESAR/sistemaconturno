package umg.principal.sistematurno.Structure;

import umg.principal.sistematurno.Model.Accion;

import java.util.Stack;

public class PilaAcciones {

    private final Stack<Accion> pila;

    public PilaAcciones() {
        this.pila = new Stack<>();
    }

    // Registrar acción (crear, editar, eliminar)
    public void registrarAccion(Accion accion) {
        pila.push(accion);
    }

    // Deshacer la última acción registrada
    public Accion deshacerUltimaAccion() {
        return pila.isEmpty() ? null : pila.pop();
    }

    public boolean estaVacia() {
        return pila.isEmpty();
    }

    public int tamaño() {
        return pila.size();
    }

    public Stack<Accion> getHistorial() {
        return pila;
    }
}
