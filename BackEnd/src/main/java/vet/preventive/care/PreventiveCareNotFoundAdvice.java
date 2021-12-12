package vet.preventive.care;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PreventiveCareNotFoundAdvice {
	
	@ResponseBody
	  @ExceptionHandler(PreventiveCareNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String PreventiveCareNotFoundHandler(PreventiveCareNotFoundException ex) {
	    return ex.getMessage();
	  }


}
