package vet.app;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class UserController {
	
	private final UserRepository repository;
	
	  UserController(UserRepository repository) {
	    this.repository = repository;
	  }
	
	  @GetMapping("/user/allusers")
	  List<User> getAllUsers() {
	    return repository.findAll();
	  }
	
	  @PostMapping("/admin/newuser")
	  User addNewUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }
	  
	  @GetMapping("/user/{id}")
	  User getSingleUser(@PathVariable Integer id) {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new UserNotFoundException(id));
	  }
	
	  @PutMapping("/admin/user/{id}")
	  User updateUser(@RequestBody User newUser, @PathVariable Integer id) {
	    
	    return repository.findById(id)
	      .map(user -> {
	        user.setType(newUser.getType());
	        return repository.save(user);
	      })
	      .orElseGet(() -> {
	        newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }
	
	  @DeleteMapping("/admin/user/{id}")
	  void deleteUser(@PathVariable Integer id) {
	    repository.deleteById(id);
	  }
	  
//	  @PutMapping("/admin/blockuser/{id}")
//	  User blockUser(@RequestBody User newUser, @PathVariable Integer id) {
//	    
//	    return repository.findById(id)
//	      .map(user -> {
//	        user.setBlocked(newUser.isBlocked());
//	        return repository.save(user);
//	      })
//	      .orElseGet(() -> {
//	        newUser.setId(id);
//	        return repository.save(newUser);
//	      });
//	  }
}
