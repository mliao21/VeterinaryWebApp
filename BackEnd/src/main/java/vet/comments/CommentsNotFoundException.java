package vet.comments;

public class CommentsNotFoundException extends RuntimeException{
	
	CommentsNotFoundException(Long id) {
	    super("Could not find Comment " + id);
	  }
}
