package com.udemy.courudemy.exeption;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException {
    @Getter
    private CodeEror codeEror;
    @Getter
    private List<String>Errors;
    public InvalidEntityException(String message) {
        super(message);

    }
    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidEntityException(String message, Throwable cause, CodeEror codeEror) {
        super(message, cause);
        this.codeEror = codeEror;
    }
     public InvalidEntityException(String message, CodeEror codeEror) {
        super(message);
        this.codeEror = codeEror;
     }
 public InvalidEntityException(String message, CodeEror codeEror,List<String>Errors) {
        super(message);
        this.codeEror = codeEror;
        this.Errors=Errors;
     }
}

