package boss.repositories;

import boss.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface MedicineRepo extends JpaRepository<Medicine,Long> {

}
