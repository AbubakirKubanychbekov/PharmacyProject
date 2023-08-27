package boss.api;

import boss.entities.Medicine;
import boss.services.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines/{pharmacyId}")
@RequiredArgsConstructor
public class MedicineApi {

    private final MedicineService medicineService;

    @GetMapping
    public List<Medicine> findAll(@PathVariable Long pharmacyId){
       return medicineService.findAll();
    }

    @PostMapping
    public String save(@RequestBody Medicine medicine,
                       @PathVariable Long pharmacyId){
        medicineService.save(pharmacyId,medicine);
        return "Medicine "+medicine+" is saved";

    }
    @PostMapping("/{id}")
    public String update(@PathVariable Long pharmacyId,
                         @PathVariable Long id,
                         @RequestBody Medicine newMedicine){
        medicineService.update(id,newMedicine);
        return "Successfully update";
    }

    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable Long pharmacyId,
                                 @PathVariable Long id){
        medicineService.deleteMedicine(id);
        return "Medicine is delete";
    }

}
