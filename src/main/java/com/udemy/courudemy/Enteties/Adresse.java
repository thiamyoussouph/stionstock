package com.udemy.courudemy.Enteties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Adresse {

    private String adress1;
    private String adress2;
    private String ville;
    private String rue;
    private String codePostal;
    private String pays;
}
