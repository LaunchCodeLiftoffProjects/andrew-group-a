package org.launchcode.andrewgroupa.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

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

        return new ResponseEntity<>(duplicateException, badRequest);
    }

}
