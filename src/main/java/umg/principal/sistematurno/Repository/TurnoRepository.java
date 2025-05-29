package umg.principal.sistematurno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umg.principal.sistematurno.Model.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
}
