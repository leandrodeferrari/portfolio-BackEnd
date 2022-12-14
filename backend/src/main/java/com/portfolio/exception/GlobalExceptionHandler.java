package com.portfolio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class,
            IllegalArgumentException.class,
            ConstraintViolationException.class,
            SQLIntegrityConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<?> badRequestExceptionHandler(RuntimeException ex){

        if (ex instanceof ConstraintViolationException constraintEx) {

            Set<ConstraintViolation<?>> violations = constraintEx.getConstraintViolations();

            return new ResponseEntity<>(violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList()), HttpStatus.BAD_REQUEST);

        }

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseBody
    public ResponseEntity<String> unauthorizedExceptionHandler(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ForbiddenException.class})
    @ResponseBody
    public ResponseEntity<String> forbiddenExceptionHandler(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    public ResponseEntity<String> notFoundExceptionHandler(RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
