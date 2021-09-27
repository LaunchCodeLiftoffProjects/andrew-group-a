package org.launchcode.andrewgroupa.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DuplicateExceptionHandler {

  @ExceptionHandler(value = {DuplicateUser.class})
  public ResponseEntity<Object> handleDuplicateUser(DuplicateUser e) {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;

    DuplicateException duplicateException = new DuplicateException(
        e.getMessage(),
        e,
        badRequest,
        ZonedDateTime.now(ZoneId.of("Z"))
    );

    System.out.println("There was an error here");

    return new ResponseEntity<>(duplicateException, badRequest);
  }

}
