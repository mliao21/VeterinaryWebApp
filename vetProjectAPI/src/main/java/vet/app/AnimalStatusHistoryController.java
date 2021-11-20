package veterinary.application;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnimalStatusHistoryController {
	
	private final AnimalStatusHistoryRepository repository;

	public AnimalStatusHistoryController(AnimalStatusHistoryRepository repository) {
	
		this.repository = repository;
	}
	
	@GetMapping("/animal_history")
	  List<AnimalStatusHistory> allAnimals() {
	    return repository.findAll();
	  }
	
	@PostMapping("/animal_history")
	AnimalStatusHistory newAnimalStatusHistory(@RequestBody AnimalStatusHistory newAnimalStatusHistory) {
	    return repository.save(newAnimalStatusHistory);
	  }
	
	@GetMapping("/animal_history/{id}")
	AnimalStatusHistory one(@PathVariable Long id) {
	    
	    return repository.findById(id).orElseThrow(() -> new  AnimalStatusHistoryNotFoundException(id));
	  }
	
	 @PutMapping("/animal_history/{id}")
	 AnimalStatusHistory replaceAnimalStatusHistory(@RequestBody AnimalStatusHistory newAnimalStatusHistory, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(animalStatus -> {
	        animalStatus.setDateAndTime(newAnimalStatusHistory.getDateAndTime());
	        animalStatus.setDescription(newAnimalStatusHistory.getDescription());
	        animalStatus.setLocation(newAnimalStatusHistory.getLocation());
	        animalStatus.setStatus(newAnimalStatusHistory.getStatus());
	        animalStatus.setAnimal(newAnimalStatusHistory.getAnimal());
	        return repository.save(animalStatus);
	      })
	      .orElseGet(() -> {
	    	  newAnimalStatusHistory.setId(id);
	        return repository.save(newAnimalStatusHistory);
	      });
	  }
	 
	 @DeleteMapping("/animal_history/{id}")
	  void deleteAnimalStatusHistory(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	

}
