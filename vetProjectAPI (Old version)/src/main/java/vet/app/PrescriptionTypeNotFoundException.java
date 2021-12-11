package vet.app;

class PrescriptionTypeNotFoundException extends RuntimeException {
	
	PrescriptionTypeNotFoundException(Integer id) {
	    super("Could not find prescription type" + id);
	}
	
}
