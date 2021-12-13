package vet.comments;

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
public class CommentsController {
	
	@Autowired
	private CommentsDAO commentsDAO;
	
	@GetMapping("/comments")
	public List<Comments> getComments(){
		return commentsDAO.getAll();
	}
	
	@GetMapping("/comments/{id}")
	public Comments getCommentsByID(@PathVariable int id) {
		return commentsDAO.getByID(id);
	}
	
	@PostMapping("/comments")
	public String saveComments(@RequestBody Comments comment) {
		return commentsDAO.save(comment) + " rows saved to DB";
	}
	
	@PutMapping("comments/{id}")
	public String updateComment(@RequestBody Comments comment, @PathVariable int id) {
		return commentsDAO.update(comment, id) + " rows updated to DB";
	}
	
	@DeleteMapping("comments/{id}")
	public String deleteComments(@PathVariable int id) {
		return commentsDAO.delete(id) + " rows deleted from DB";
	}
	
}
