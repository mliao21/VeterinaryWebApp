package request;

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
public class RequestController {
	
	@Autowired
	private RequestDAO reqDAO;
	
	@GetMapping("/requests")
	public List<Request> getRequest(){
		return reqDAO.getAll();
	}
	
	@GetMapping("/requests/requestStatus")
	public Request getAvailableAnimals(){
		return reqDAO.getByStatus();
	}
	
	@DeleteMapping("requests/{animalId}")
	public String deleteAnimal(@PathVariable int animalId) {
		return reqDAO.delete(animalId) + " rows deleted from DB";
	}
	
	@PostMapping("/requests")
	public String saveRequest(@RequestBody Request requests) {
		return reqDAO.save(requests) + " rows saved to DB";
	} 
	
	@PutMapping("requests/{animalId}")
	public String updatRequest(@RequestBody Request requests, @PathVariable int animalId) {
		return reqDAO.update(requests, animalId) + " rows updated to DB";
	}
	
	
	
	

}
