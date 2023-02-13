package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entreprises extends Abstractentities {
    private String nom;
    @Embedded
    private Adresse adresse;
    private String codeFiscal;
    private String photo;
    private String mail;
    private String numTel;
    private String description;
    @OneToMany(mappedBy = "entreprises")
    private List<Utilisateur>utilisateurs;
}
