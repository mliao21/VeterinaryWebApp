package veterinary.application;

public class AnimalNotFoundException extends RuntimeException {
	
	AnimalNotFoundException(Long id) {
	    super("Could not find animal " + id);
	  }

}
