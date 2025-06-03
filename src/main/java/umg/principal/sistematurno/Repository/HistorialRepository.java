package umg.principal.sistematurno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.principal.sistematurno.Model.Historial;

public interface HistorialRepository extends JpaRepository<Historial, Long> {
}
