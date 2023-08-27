package boss.entities;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDate;

public class Listens {

    @PrePersist
    public void save(Pharmacy pharmacy) {
        pharmacy.setCreatedEt(LocalDate.now());
        pharmacy.setUpdatedEt(LocalDate.now());
    }

    @PreUpdate
    public void onPreUpdate(Pharmacy pharmacy) {
        pharmacy.setUpdatedEt(LocalDate.now());
    }

}
