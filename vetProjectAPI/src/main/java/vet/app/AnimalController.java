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
public class AnimalController {

	private final AnimalRepository repository;

	public AnimalController(AnimalRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/animals")
	List<Animal> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/animals")
	Animal newAnimal(@RequestBody Animal newAnimal) {
		return repository.save(newAnimal);
	}

	// Single item

	@GetMapping("/animals/{id}")
	Animal one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new AnimalNotFoundException(id));
	}

	@PutMapping("/employees/{id}")
	Animal replaceAnimal(@RequestBody Animal newAnimal, @PathVariable Long id) {

		return repository.findById(id).map(animal -> {
			animal.setType(newAnimal.getType());
			animal.setWeight(newAnimal.getWeight());
			animal.setDOB(newAnimal.getDOB());
			animal.setSex(newAnimal.getSex());
			animal.setColour(newAnimal.getColour());
			animal.setBread(newAnimal.getBread());
			animal.setTattoo(newAnimal.getTattoo());
			animal.setCity(newAnimal.getCity());
			animal.setRFID(newAnimal.getRFID());
			animal.setMicrochirp(newAnimal.getMicrochirp());
			animal.setStatus(newAnimal.getStatus());
			animal.setDraught(newAnimal.getDraught());
			animal.setMeat(newAnimal.getMeat());
			animal.setRegion(newAnimal.getRegion());
			animal.setSubspecies(newAnimal.getSubspecies());
			animal.setDistinguishing(newAnimal.getDistinguishing());
			animal.setFeatures(newAnimal.getFeatures());

			return repository.save(animal);
		}).orElseGet(() -> {
			newAnimal.setId(id);
			return repository.save(newAnimal);
		});
	}

	@DeleteMapping("/animals/{id}")
	void deleteAnimals(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
