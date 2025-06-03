package umg.principal.sistematurno.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import umg.principal.sistematurno.Model.LogAccion;

public interface LogAccionRepository extends MongoRepository<LogAccion, String> {
}
