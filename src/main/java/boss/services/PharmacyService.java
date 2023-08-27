package boss.services;

import boss.entities.Pharmacy;
import boss.repositories.PharmacyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PharmacyService {

    private final PharmacyRepo pharmacyRepo;

    public List<Pharmacy> findAll(){
        return pharmacyRepo.findAll();
    }

    public void save(Pharmacy newPharmacy) {
        pharmacyRepo.save(newPharmacy);
    }

    public Pharmacy findById(Long id){
      return pharmacyRepo.findById(id).orElseThrow(()->
                 new NoSuchElementException("Pharmacy with id: "+id+" not found"));
    }


    @Transactional
    public String update(Long id, Pharmacy newPharmacy){
        Pharmacy currentPharmacy = findById(id);
        currentPharmacy.setName(newPharmacy.getName());
        currentPharmacy.setAddress(newPharmacy.getAddress());
        return "successfully update";
    }


    public String delete(Long id) {
        pharmacyRepo.deleteById(id);
        return "Pharmacy: "+id+" is deleted";
    }
}
