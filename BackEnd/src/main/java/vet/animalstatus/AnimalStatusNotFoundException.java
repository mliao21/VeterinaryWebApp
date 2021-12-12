package vet.animalstatus;

public class AnimalStatusNotFoundException extends RuntimeException{
	
	AnimalStatusNotFoundException(Long id) {
	    super("Could not find animalStauts " + id);
	  }
}
