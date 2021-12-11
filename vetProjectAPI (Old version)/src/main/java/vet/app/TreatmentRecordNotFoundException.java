package vet.app;

class TreatmentRecordNotFoundException extends RuntimeException {
	
	TreatmentRecordNotFoundException(Integer id) {
	    super("Could not find treatment record" + id);
	}
	
}
