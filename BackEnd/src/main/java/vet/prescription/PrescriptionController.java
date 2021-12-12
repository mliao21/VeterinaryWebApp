package prescription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import animalstatus.AnimalStatus;

@RestController
public class PrescriptionController {
	
	@Autowired
	private PrescriptionDAO pDAO;
	
	@GetMapping("/prescriptions")
	public List<Prescription> getPrescription(){
		return pDAO.getAllPrescriptions();
	}
	
	@GetMapping("/prescriptions/{id}")
	public Prescription getPrescriptionsByID(@PathVariable int id){//
		return pDAO.getByID(id);
	}
	
	@PostMapping("/prescriptions")
	public String animalStatus(@RequestBody Prescription prescriptions) {
		return pDAO.save(prescriptions) + " rows saved to DB";
	}
	
	@PutMapping("prescriptions/{id}")
	public String updateAnimal(@RequestBody Prescription prescriptions, @PathVariable int id) {
		return pDAO.update(prescriptions, id) + " rows updated to DB";
	}
	
	@DeleteMapping("Prescription/{id}")
	public String deleteAnimalStatus(@PathVariable int id) {
		return pDAO.delete(id) + " rows deleted from DB";
	}
	
}
