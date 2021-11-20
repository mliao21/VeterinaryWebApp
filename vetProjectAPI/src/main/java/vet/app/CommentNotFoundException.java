package veterinary.application;

public class CommentNotFoundException extends RuntimeException{
	
	CommentNotFoundException(Long id) {
	    super("Could not comment " + id);
	}

}
