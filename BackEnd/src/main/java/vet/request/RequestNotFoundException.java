package vet.request;

public class RequestNotFoundException extends RuntimeException{
	
	RequestNotFoundException(Long animalId) {
	    super("Could not find request" + animalId);
	  }

}
