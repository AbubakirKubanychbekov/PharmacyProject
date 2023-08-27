package boss.api;

import boss.entities.Worker;
import boss.services.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers/{pharmacyId}")
@RequiredArgsConstructor
public class WorkerApi {

    private final WorkerService workerService;

    @GetMapping
    public List<Worker> findAll(@PathVariable Long pharmacyId){
        return workerService.findAll();
    }

    @PostMapping
    public String save(@RequestBody Worker newWorker,
                       @PathVariable Long pharmacyId){
      workerService.save(newWorker,pharmacyId);
      return "Worker: "+newWorker+" is saved";
    }

    @PostMapping("/{id}")
    public String updateWorker(@PathVariable Long pharmacyId,
                               @PathVariable Long id,
                               @RequestBody Worker newWorker){
        workerService.update(id,newWorker);
        return "Worker: "+id+" is updated";
    }

    @DeleteMapping("/{id}")
    public String deleteWorker(@PathVariable Long pharmacyId,
                               @PathVariable Long id){
       return workerService.delete(id);
    }
}
