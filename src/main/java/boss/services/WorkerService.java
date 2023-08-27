package boss.services;

import boss.entities.Pharmacy;
import boss.entities.Worker;
import boss.repositories.PharmacyRepo;
import boss.repositories.WorkerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RepositoryRestResource
@RequiredArgsConstructor
@Transactional
public class WorkerService {

    private final WorkerRepo workerRepo;

    public final PharmacyRepo pharmacyRepo;

    public List<Worker> findAll() {
        return workerRepo.findAll();
    }

    @Transactional
    public void save(Worker newWorker,Long pharmacyId) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(
                () -> new NoSuchElementException("Pharmacy with id:" + " not found"));
        pharmacy.getWorkers().add(newWorker);
        newWorker.setPharmacy(pharmacy);
        workerRepo.save(newWorker);
    }


    public Worker findById(Long id){
       return workerRepo.findById(id).orElseThrow(
                ()-> new NullPointerException("Worker with id:"+id+" not found"));
    }

    @Transactional
    public String update(Long id, Worker newWorker) {
        Worker currentWorker = findById(id);
        currentWorker.setName(newWorker.getName());
        currentWorker.setEmail(newWorker.getEmail());
        currentWorker.setSalary(newWorker.getSalary());
        currentWorker.setAddress(newWorker.getAddress());
        currentWorker.setDateOfBirth(newWorker.getDateOfBirth());
        return "worker successfully updated";
    }

    public String delete(Long id) {
        workerRepo.deleteById(id);
        return "Worker with id:"+id+" is deleted";
    }
}
