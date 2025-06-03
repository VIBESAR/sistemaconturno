package umg.principal.sistematurno.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs")
public class LogAccion {

    @Id
    private String id;
    private String tipo;
    private String descripcion;
    private LocalDateTime fecha;

    public LogAccion(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }

    // Getters y setters
}
