package com.yom.blinddate.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleConflict(RuntimeException ex, HttpServletRequest request) {
        System.out.println(Arrays.toString(ex.getStackTrace()));
        System.out.println(request.getRequestURI());
        return ResponseEntity.badRequest().body("exception handler error!");
    }
}
