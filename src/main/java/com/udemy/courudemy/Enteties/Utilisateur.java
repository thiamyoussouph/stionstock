package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur  extends Abstractentities {

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String photo;
    private boolean actived;
    @ManyToOne
    private Entreprises entreprises;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;
}

