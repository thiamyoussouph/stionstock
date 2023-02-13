package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fournisseurs extends Abstractentities {
    private String nom;
    private String prenom;
    private String adresse;
    private String photo;
    private String mail;
    private String numTel;
    private int identreprise;
    @OneToMany(mappedBy = "fournisseurs")
    private List<Commandefourniseur> commandeFournisseurs;
}
