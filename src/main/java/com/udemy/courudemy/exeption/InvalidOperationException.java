package com.udemy.courudemy.exeption;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException{
    @Getter
    private CodeEror codeEror;

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperationException(String message, Throwable cause, CodeEror codeEror) {
        super(message, cause);
        this.codeEror = codeEror;
    }

    public InvalidOperationException(String message, CodeEror codeEror) {
        super(message);
        this.codeEror = codeEror;
    }

}
