package vet.app;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreatmentRecordController {

  private final TreatmentRecordRepository repository;

  TreatmentRecordController(TreatmentRecordRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/treatment/records")
  List<TreatmentRecord> getAllTreatmentRecords() {
    return repository.findAll();
  }

  @PostMapping("/treatment/records")
  TreatmentRecord addNewTreatmentRecord(@RequestBody TreatmentRecord newTreatment) {
    return repository.save(newTreatment);
  }
  
  @GetMapping("/treatment/records/{id}")
  TreatmentRecord getSingleTreatmentRecord(@PathVariable Integer id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new TreatmentRecordNotFoundException(id));
  }

  @PutMapping("/treatment/records/{id}")
  TreatmentRecord replaceExistingTreatmentRecord(@RequestBody TreatmentRecord newTreatment, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(treatment -> {
        treatment.setCreationDate(newTreatment.getCreationDate());
        treatment.setTreatmentType(newTreatment.getTreatmentType());
        treatment.setAnimalId(newTreatment.getAnimalId());
        treatment.setStage(newTreatment.getStage());
        treatment.setComment(newTreatment.getComment());
        treatment.setLastUpdate(newTreatment.getLastUpdate());
        treatment.setUserId(newTreatment.getUserId());
        return repository.save(treatment);
      })
      .orElseGet(() -> {
        newTreatment.setId(id);
        return repository.save(newTreatment);
      });
  }
  
  @PutMapping("/treatment/records/stage/{id}")
  TreatmentRecord updateTreatmentStage(@RequestBody TreatmentRecord newTreatment, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(treatment -> {
        treatment.setStage(newTreatment.getStage());
        return repository.save(treatment);
      })
      .orElseGet(() -> {
        newTreatment.setId(id);
        return repository.save(newTreatment);
      });
  }
  
  @PutMapping("/treatment/records/comment/{id}")
  TreatmentRecord addTreatmentComment(@RequestBody TreatmentRecord newTreatment, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(treatment -> {
        treatment.setComment(treatment.getComment() + ", " + newTreatment.getComment());
        return repository.save(treatment);
      })
      .orElseGet(() -> {
        newTreatment.setId(id);
        return repository.save(newTreatment);
      });
  }
  
  @DeleteMapping("/treatment/records/{id}")
  void deleteTreatmentRecord(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
