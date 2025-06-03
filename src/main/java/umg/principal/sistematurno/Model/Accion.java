package umg.principal.sistematurno.Model;

public class Accion {
    private String tipo; // ejemplo: "crear", "editar", "eliminar"
    private Turno turno;

    public Accion(String tipo, Turno turno) {
        this.tipo = tipo;
        this.turno = turno;
    }

    public String getTipo() {
        return tipo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
