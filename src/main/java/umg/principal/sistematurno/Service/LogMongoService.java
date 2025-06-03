package umg.principal.sistematurno.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class LogMongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void log(String accion, String descripcion) {
        Map<String, Object> doc = new HashMap<>();
        doc.put("accion", accion);
        doc.put("descripcion", descripcion);
        doc.put("timestamp", LocalDateTime.now());

        mongoTemplate.save(doc, "logAccion"); // "logAccion" es el nombre de la colección
    }
}
