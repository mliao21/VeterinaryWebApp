package vet.preventive.care;

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
public class PreventiveCareController {
	
	@Autowired
	private PreventiveCareDAO preDAO;
	
	@GetMapping("/preventiveCare")
	public List<PreventiveCare> getPreventiveCare(){
		return preDAO.getAll();
	}
	
	@GetMapping("/preventiveCare/id")
	public PreventiveCare getPreventiveCarebyId(@PathVariable int id){
		return preDAO.getByID(id);
	}
	
	@PutMapping("preventiveCare/{id}")
	public String preventiveCare(@RequestBody PreventiveCare preventiveCare, @PathVariable int id) {
		return preDAO.update(preventiveCare, id) + " rows updated in DB";
	}
	
	@DeleteMapping("preventiveCare/{id}")
	public String deletePreventiveCare(@PathVariable int id) {
		return preDAO.delete(id) + " rows deleted from DB";
	}
}
