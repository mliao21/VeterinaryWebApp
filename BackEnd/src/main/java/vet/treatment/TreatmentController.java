package treatment;

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
public class TreatmentController {
	
	@Autowired
	private TreatmentDAO treDAO;
	
	@GetMapping("/treatments")
	public List<Treatment> getTreatments(){
		return treDAO.getAll();
	}
	
	@GetMapping("/treatments/{id}")
	public Treatment getTreatmentsByID(@PathVariable int id) {
		return treDAO.getByID(id);
	}
	
	@PostMapping("/treatments")
	public String saveTreatments(@RequestBody Treatment treatments) {
		return treDAO.save(treatments) + " rows saved to DB";
	}
	
	@PutMapping("treatments/{id}")
	public String updateTreatment(@RequestBody Treatment treatments, @PathVariable int id) {
		return treDAO.update(treatments, id) + " rows updated to DB";
	}
	
	@DeleteMapping("treatments/{id}")
	public String deleteTreatment(@PathVariable int id) {
		return treDAO.delete(id) + " rows deleted from DB";
	}
	
	@GetMapping("/treatments/new_treatment_requests")
	public List<Treatment> getNewRequests(){
		return treDAO.getNewTreatment();
	}

}
