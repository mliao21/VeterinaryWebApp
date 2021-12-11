package vet.app;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	
	private final CommentRepository repository;
	
	public CommentController(CommentRepository repository) {
		super();
		this.repository = repository;
	}

	// Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/comment")
	  List<Comment> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]
	  
	  @PostMapping("/comment")
	  Comment newEmployee(@RequestBody Comment newComment) {
	    return repository.save(newComment);
	  }

	  // Single item
	  
	  @GetMapping("/comment/{id}")
	  Comment one(@PathVariable Long id) {
	    
	    return repository.findById(id)
	      .orElseThrow(() -> new CommentNotFoundException(id));
	  }

	  @PutMapping("/comment/{id}")
	  Comment replaceComment(@RequestBody Comment newComment, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(comment -> {
	        comment.setUser(newComment.getUser());
	        comment.setAnimal(newComment.getAnimal());
	        comment.setDescription(newComment.getDescription());
	        return repository.save(comment);
	      })
	      .orElseGet(() -> {
	        newComment.setId(id);
	        return repository.save(newComment);
	      });
	  }

	  @DeleteMapping("/comment/{id}")
	  void deleteComment(@PathVariable Long id) {
	    repository.deleteById(id);
	  }

	

}
