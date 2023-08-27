package boss.api;

import boss.entities.Pharmacy;
import boss.services.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacies")
@RequiredArgsConstructor
public class PharmacyApi {

private final PharmacyService pharmacyService;

    @GetMapping
    public List<Pharmacy> findAll(){
        return pharmacyService.findAll();
    }

  @PostMapping
    public String save(@RequestBody Pharmacy newPharmacy){
        pharmacyService.save(newPharmacy);
    return "successfully"+newPharmacy+"is saved";
  }

   @PostMapping("/{id}")
   public String update(@RequestBody Pharmacy newPharmacy,@PathVariable Long id){
        return pharmacyService.update(id,newPharmacy);
    }

  @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
      return pharmacyService.delete(id);
  }
}
