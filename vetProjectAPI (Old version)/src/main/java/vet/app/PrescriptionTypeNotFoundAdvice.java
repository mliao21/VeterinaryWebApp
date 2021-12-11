package vet.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PrescriptionTypeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PrescriptionTypeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String prescriptionTypeNotFoundHandler(PrescriptionTypeNotFoundException ex) {
    return ex.getMessage();
  }
}