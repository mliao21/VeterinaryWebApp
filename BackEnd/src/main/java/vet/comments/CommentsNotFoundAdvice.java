package vet.comments;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import vet.treatment.TreatmentNotFoundException;

@ControllerAdvice
public class CommentsNotFoundAdvice {
	
	  @ResponseBody
	  @ExceptionHandler(CommentsNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String TreatmentNotFoundHandler(CommentsNotFoundException ex) {
	    return ex.getMessage();
	  }
	
}
