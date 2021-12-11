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
public class TreatmentMethodController {

  private final TreatmentMethodRepository repository;

  TreatmentMethodController(TreatmentMethodRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/treatment/methods")
  List<TreatmentMethod> getAllTreatmentMethods() {
    return repository.findAll();
  }

  @PostMapping("/treatment/methods")
  TreatmentMethod addNewTreatmentMethod(@RequestBody TreatmentMethod newTreatment) {
    return repository.save(newTreatment);
  }
  
  @GetMapping("/treatment/methods/{id}")
  TreatmentMethod getSingleTreatmentMethod(@PathVariable Integer id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new TreatmentMethodNotFoundException(id));
  }

  @PutMapping("/treatment/methods/{id}")
  TreatmentMethod replaceExistingTreatmentMethod(@RequestBody TreatmentMethod newTreatment, @PathVariable Integer id) {
    
    return repository.findById(id)
      .map(treatment -> {
        treatment.setType(newTreatment.getType());
        return repository.save(treatment);
      })
      .orElseGet(() -> {
        newTreatment.setId(id);
        return repository.save(newTreatment);
      });
  }

  @DeleteMapping("/treatment/methods/{id}")
  void deleteTreatmentMethod(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
