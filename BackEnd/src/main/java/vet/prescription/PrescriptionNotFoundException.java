package vet.prescription;

public class PrescriptionNotFoundException extends RuntimeException {
	
	PrescriptionNotFoundException(Long id)  {
	    super("Could not find prescription " + id);
	  }


}
