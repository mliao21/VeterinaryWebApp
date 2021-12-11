package vet.app;

class TreatmentMethodNotFoundException extends RuntimeException {
	
	TreatmentMethodNotFoundException(Integer id) {
	    super("Could not find treatment method" + id);
	}
	
}
