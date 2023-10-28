package com.project.LoanApplicationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoanException {
    @ExceptionHandler(LoanAlreadyExistException.class)
    public ResponseEntity<?> loanAlreadyExistsException(LoanAlreadyExistException bae) {
        return new ResponseEntity("Loan Already Exists", HttpStatus.FOUND);
    }
    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<?> handleLoanNotFoundException(LoanNotFoundException nae) {
        return new ResponseEntity("Loan application Not Found",HttpStatus.NOT_FOUND);
    }

}
