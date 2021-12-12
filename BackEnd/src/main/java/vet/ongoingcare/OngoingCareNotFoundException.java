package vet.ongoingcare;

public class OngoingCareNotFoundException extends RuntimeException {
	
	OngoingCareNotFoundException(Long id) {
		super("Could not find animal ongoing care " + id);
	}

}
