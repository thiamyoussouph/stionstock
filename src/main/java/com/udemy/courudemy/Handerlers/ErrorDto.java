package com.udemy.courudemy.Handerlers;

import com.udemy.courudemy.exeption.CodeEror;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private String message;
    private CodeEror codeEror;
    private List<String>Errors =new ArrayList<>();
}
