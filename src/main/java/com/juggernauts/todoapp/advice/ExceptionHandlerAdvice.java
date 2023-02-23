package com.juggernauts.todoapp.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    // break
    private static final Logger logger = LogManager.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(Exception.class) 
    public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        logger.error("error handling {} to {}", request.getMethod(), request.getRequestURL(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

//
