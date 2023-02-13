package com.udemy.courudemy.exeption;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
    @Getter
    private CodeEror codeEror;
    public EntityNotFoundException(String message) {
        super(message);

    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EntityNotFoundException(String message, Throwable cause, CodeEror codeEror) {
        super(message, cause);
        this.codeEror = codeEror;
    }

    public EntityNotFoundException(String message, CodeEror codeEror) {
        super(message);
        this.codeEror = codeEror;
    }
}
