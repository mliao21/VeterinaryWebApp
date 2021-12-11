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
public class PrescriptionRecordController {

  private final PrescriptionRecordRepository repository;

  PrescriptionRecordController(PrescriptionRecordRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/prescription/records")
  List<PrescriptionRecord> getAllPrescriptionRecords() {
    return repository.findAll();
  }

  @PostMapping("/prescription/records")
  PrescriptionRecord addNewPrescriptionRecord(@RequestBody PrescriptionRecord newPrescription) {
    return repository.save(newPrescription);
  }
  
  @GetMapping("/prescription/records/{id}")
  PrescriptionRecord getSinglePrescriptionRecord(@PathVariable Integer id) {
    return repository.findById(id)
      .orElseThrow(() -> new PrescriptionRecordNotFoundException(id));
  }

  @PutMapping("/prescription/records/{id}")
  PrescriptionRecord replaceExistingPrescriptionRecord(@RequestBody PrescriptionRecord newPrescription, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(prescription -> {
        prescription.setTreatmentId(newPrescription.getTreatmentId());
        prescription.setType(newPrescription.getType());
        prescription.setSchedule(newPrescription.getSchedule());
        prescription.setDescription(newPrescription.getDescription());
        prescription.setLastUpdate(newPrescription.getLastUpdate());
        prescription.setUserId(newPrescription.getUserId());
        return repository.save(prescription);
      })
      .orElseGet(() -> {
        newPrescription.setId(id);
        return repository.save(newPrescription);
      });
  }

  @DeleteMapping("/prescription/records/{id}")
  void deletePrescriptionRecord(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
