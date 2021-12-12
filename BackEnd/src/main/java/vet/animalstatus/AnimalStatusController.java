package vet.animalstatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalStatusController {
	
	@Autowired
	private AnimalStatusDAO aDAO;

	@GetMapping("/animalStatus")
	public List<AnimalStatus> getAnimalStatus(){
		return aDAO.getAllAnimalStatus();
	}
	
	@GetMapping("/animalStatus/{id}")
	public AnimalStatus getAnimalByID(@PathVariable int id) {
		return aDAO.getByID(id);
	}
	
	@PostMapping("/animalStatus")
	public String animalStatus(@RequestBody AnimalStatus animalStatus) {
		return aDAO.save(animalStatus) + " rows saved to DB";
	}
	
	@PutMapping("animalStatus/{id}")
	public String updateAnimal(@RequestBody AnimalStatus animalStatus, @PathVariable int id) {
		return aDAO.update(animalStatus, id) + " rows updated to DB";
	}
	
	@DeleteMapping("animalStatus/{id}")
	public String deleteAnimalStatus(@PathVariable int id) {
		return aDAO.delete(id) + " rows deleted from DB";
	}
}
