package com.udemy.courudemy.Handerlers;

import com.udemy.courudemy.exeption.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class RestException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest request) {
    final HttpStatus notFound = HttpStatus.NOT_FOUND;
    final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .codeEror(exception.getCodeEror())
                .build();
        return new ResponseEntity<>(errorDto, notFound);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleInvalidEntityException(EntityNotFoundException exception, WebRequest request) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .codeEror(exception.getCodeEror())
                .build();
        return new ResponseEntity<>(errorDto, badRequest);


    }
}


