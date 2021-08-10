package com.yom.blinddate.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
/*
https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
https://www.baeldung.com/exception-handling-for-rest-with-spring
https://supawer0728.github.io/2019/04/04/spring-error-handling/
https://www.baeldung.com/global-error-handler-in-a-spring-rest-api
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleConflict(RuntimeException ex, HttpServletRequest request) {
        System.out.println(ex.getClass());
        System.out.println(request.getRequestURI());
        return ResponseEntity.badRequest().body("exception handler error!");
    }
}
