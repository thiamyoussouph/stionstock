package com.udemy.courudemy.Enteties;

import com.udemy.courudemy.Abstractentities;
import com.udemy.courudemy.Enum.SourcemouvementStok;
import com.udemy.courudemy.Enum.TypeMouvement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mouvementstock extends Abstractentities {
    @ManyToOne
   private Article article;
    private Instant dateMouvement;
    private BigDecimal quantite;
    @Enumerated(EnumType.STRING)
    private TypeMouvement typeMouvement;
    private int identreprise;
    @Enumerated(EnumType.STRING)
    private SourcemouvementStok sourcemouvementStok;
}
