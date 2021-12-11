package vet.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ImagesNotFoundAdvice {
	
	 @ResponseBody
	  @ExceptionHandler(ImagesNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String imageNotFoundHandler(ImagesNotFoundException ex) {
	    return ex.getMessage();
	  }
	
	}
