package com.assigiment.payrollService;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> springHandleNotFound(Exception ex, WebRequest wq) throws Exception {
        ErrorMessage em = new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return new ResponseEntity<>(
            em, new HttpHeaders(),HttpStatus.NOT_FOUND
        );
    }
}
