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
public class PrescriptionTypeController {

  private final PrescriptionTypeRepository repository;

  PrescriptionTypeController(PrescriptionTypeRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/prescription/types")
  List<PrescriptionType> getAllPrescriptionTypes() {
    return repository.findAll();
  }

  @PostMapping("/prescription/types")
  PrescriptionType addNewPrescriptionType(@RequestBody PrescriptionType newPrescription) {
    return repository.save(newPrescription);
  }
  
  @GetMapping("/prescription/types/{id}")
  PrescriptionType getSinglePrescriptionType(@PathVariable Integer id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new PrescriptionTypeNotFoundException(id));
  }

  @PutMapping("/prescription/types/{id}")
  PrescriptionType replaceExistingPrescriptionType(@RequestBody PrescriptionType newPrescription, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(prescription -> {
        prescription.setType(newPrescription.getType());
        return repository.save(prescription);
      })
      .orElseGet(() -> {
        newPrescription.setId(id);
        return repository.save(newPrescription);
      });
  }

  @DeleteMapping("/prescription/types/{id}")
  void deletePrescriptionType(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
