package vet.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/users")
	public List<User> getAll(){
		return userDAO.getAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserByID(@PathVariable int id) {
		return userDAO.getByID(id);
	}
	
	@PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
       userDAO.save(user); 
       return ResponseEntity.ok("User registered successfully!"); //new MessageResponse("User registered successfully!"));
    }
	
	@PutMapping("/users/{id}")
	public String updateUser(@RequestBody User user, @PathVariable int id) {
		return userDAO.update(user, id) + " rows updated to DB";
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		return userDAO.delete(id) + " rows deleted from DB";
	}
	

}
