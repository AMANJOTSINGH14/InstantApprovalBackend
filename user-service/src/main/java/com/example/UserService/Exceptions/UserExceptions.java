package com.example.UserService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shubhampatil
 */
@RestControllerAdvice
public class UserExceptions {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException c){
        return new ResponseEntity<>("USER NOT FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(){
        return new ResponseEntity<>("USER ALREADY EXISTS", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordNotMatch.class)
    public ResponseEntity<?> handlePasswordNotMatch(){
        return new ResponseEntity<>("PLEASE ENTER CORRECT CURRENT PASSWORD", HttpStatus.NOT_FOUND);
    }
}
