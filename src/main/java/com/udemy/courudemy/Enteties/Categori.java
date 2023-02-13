package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
public class Categori extends Abstractentities {
    private String code;
    private int identreprise;

    private String description;
    @OneToMany(mappedBy = "categori")
    private List<Article> articles;


}

