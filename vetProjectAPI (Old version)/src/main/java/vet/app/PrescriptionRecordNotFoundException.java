package vet.app;

class PrescriptionRecordNotFoundException extends RuntimeException {
	
	PrescriptionRecordNotFoundException(Integer id) {
	    super("Could not find prescription record" + id);
	}
	
}
