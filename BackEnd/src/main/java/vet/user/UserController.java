package vet.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vet.treatment.Treatment;

@RestController
public class UserController {
	
	private UserDAO userDAO;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userDAO.getAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserByID(@PathVariable int id) {
		return userDAO.getByID(id);
	}
	
	@PostMapping("/users")
	public String saveUser(@RequestBody User user) {
		return userDAO.save(user) + " rows saved to DB";
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
