package org.ayush.Exceptions;

import org.ayush.Exceptions.ProductAlreadyExistsException;
import org.ayush.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> productNotFoundException(){
        return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ProductAlreadyExistsException.class)
    public ResponseEntity<Object> productAlreadyExistsException(){
        return new ResponseEntity<>("Product Already Exists", HttpStatus.CONFLICT);
    }

}
