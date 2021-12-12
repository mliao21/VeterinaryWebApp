package vet.ongoingcare;

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
public class OngoingCareController {

	@Autowired
	private OngoingCareDAO ongoingCareDAO;
	
	@GetMapping("/ongoing_cares")
	public List<OngoingCare> getOngoingCares(){
		return ongoingCareDAO.getAll();
	}
	
	@GetMapping("/ongoing_cares/{id}")
	public OngoingCare getOngoingCareByID(@PathVariable int animalId) {
		return ongoingCareDAO.getByID(animalId);
	}
	
	@PostMapping("/ongoing_cares")
	public String saveOngoingCare(@RequestBody OngoingCare ongoing_care) {
		return ongoingCareDAO.save(ongoing_care) + " rows saved to DB";
	}
	
	@PutMapping("ongoing_cares/{id}")
	public String updateOngoingCare(@RequestBody OngoingCare ongoing_care, @PathVariable int animalId, @PathVariable int preventiveCareId) {
		return ongoingCareDAO.update(ongoing_care, animalId, preventiveCareId) + " rows updated to DB";
	}
	
	@DeleteMapping("ongoing_cares/{id}")
	public String deleteOngoingCare(@PathVariable int animalId, @PathVariable int preventiveCareId) {
		return ongoingCareDAO.delete(animalId, preventiveCareId) + " rows deleted from DB";
	}
	
}
