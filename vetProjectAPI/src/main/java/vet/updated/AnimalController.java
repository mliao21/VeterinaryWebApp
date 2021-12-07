package com.example.demo;

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
public class AnimalController {

	@Autowired
	private AnimalDAO aDAO;
	
	@GetMapping("/animals")
	public List<Animal> getAnimals(){
		return aDAO.getAll();
	}
	
	@GetMapping("/animals/available")
	public List<Animal> getAvailableAnimals(){
		return aDAO.getAvailableAnimals();
	}
	
	@GetMapping("/animals/new_animal_requests")
	public List<Animal> getNewRequests(){
		return aDAO.getNewRequests();
	}
	
	@GetMapping("/animals/pending_animal_requests")
	public List<Animal> getPendingAnimalRequests(){
		return aDAO.getPendingAnimalRequests();
	}
	
	@GetMapping("/animals/approved_by_admin_requests")
	public List<Animal> getApprovedByAdminRequests(){
		return aDAO.getApprovedByAdminRequests();
	}
	
	@GetMapping("/animals/{id}")
	public Animal getAnimalByID(@PathVariable int id) {
		return aDAO.getByID(id);
	}
	
	@PostMapping("/animals")
	public String saveAnimal(@RequestBody Animal animal) {
		return aDAO.save(animal) + " rows saved to DB";
	}
	
	@PutMapping("animals/{id}")
	public String updateAnimal(@RequestBody Animal animal, @PathVariable int id) {
		return aDAO.update(animal, id) + " rows updated to DB";
	}
	
	@DeleteMapping("animals/{id}")
	public String deleteAnimal(@PathVariable int id) {
		return aDAO.delete(id) + " rows deleted from DB";
	}
	
}
