package boss.repositories;

import boss.entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepo extends JpaRepository<Pharmacy,Long> {

}
