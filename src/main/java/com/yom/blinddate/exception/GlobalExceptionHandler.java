package com.yom.blinddate.exception;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleConflict(RuntimeException ex, HttpServletRequest request) {
        log.error("{}", ex.toString());
        log.error("Request-URI : {}", request.getRequestURI());
        return ResponseEntity.internalServerError().body("exception handler error!");
    }
}
