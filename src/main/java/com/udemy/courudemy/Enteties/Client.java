package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Client extends Abstractentities {
    private String name;
    private String prenom;
    private String email;
    private String photo;
    private int identreprise;
    @Embedded
    private Adresse adresse;
    private String tel;
    @OneToMany(mappedBy = "client")
    private List<CommandeClients> commandeClients;
}

