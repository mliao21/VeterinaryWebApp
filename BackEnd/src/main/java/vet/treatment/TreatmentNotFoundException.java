package vet.treatment;

public class TreatmentNotFoundException extends RuntimeException{
	
	TreatmentNotFoundException(Long id) {
	    super("Could not find Treatment " + id);
	  }

}
