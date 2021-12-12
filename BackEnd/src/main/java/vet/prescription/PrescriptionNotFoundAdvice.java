package vet.prescription;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PrescriptionNotFoundAdvice {
	

	 @ResponseBody
	  @ExceptionHandler(PrescriptionNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String PrescriptionNotFoundHandler(PrescriptionNotFoundException ex) {
	    return ex.getMessage();
	  }

}
