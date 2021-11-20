package vet.app;

public class AnimalStatusHistoryNotFoundException extends RuntimeException{
	
	AnimalStatusHistoryNotFoundException (Long id) {
		
		super("Could not find animal staus history " + id);
	}

}
