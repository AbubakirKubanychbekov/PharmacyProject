package boss.services;

import boss.entities.Medicine;
import boss.entities.Pharmacy;
import boss.repositories.MedicineRepo;
import boss.repositories.PharmacyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicineService {

    private final MedicineRepo medicineRepo;
    private final PharmacyRepo pharmacyRepo;

    public List<Medicine> findAll() {
        return medicineRepo.findAll();
    }

    @Transactional
    public void save(Long pharmacyId, Medicine medicine) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(() ->
                new NoSuchElementException("Pharmacy with id: " + pharmacyId + " not found"));
        pharmacy.getMedicines().add(medicine);
        medicine.getPharmacies().add(pharmacy);
        medicineRepo.save(medicine);
    }

    public Medicine findById(Long id){
      return medicineRepo.findById(id).orElseThrow(()->
                new NullPointerException("Medicine with id: "+id+" not found"));
    }

    @Transactional
    public String update(Long id, Medicine newMedicine) {
        Medicine med = findById(id);
        med.setName(newMedicine.getName());
        med.setPrice(newMedicine.getPrice());
        med.setPharmacies(newMedicine.getPharmacies());
        return "Successfully updated";
    }

    public String deleteMedicine(Long id) {
      medicineRepo.deleteById(id);
      return "Medicine is deleted";
    }
}
