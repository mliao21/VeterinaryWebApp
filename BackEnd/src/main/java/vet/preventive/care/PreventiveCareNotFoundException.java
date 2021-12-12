package preventive.care;

public class PreventiveCareNotFoundException extends RuntimeException {
	
	 PreventiveCareNotFoundException(Long id)  {
	    super("Could not find preventive care " + id);
	  }

}
