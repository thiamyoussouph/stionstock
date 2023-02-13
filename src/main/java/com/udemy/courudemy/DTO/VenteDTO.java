package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class VenteDTO {
    private long id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private int identreprise;
    public static VenteDTO fromEntity(Ventes ventes){
        if(ventes==null){
            return null;
        }
        return VenteDTO.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .commentaire(ventes.getCommentaire())
                .identreprise(ventes.getIdentreprise())
                .build();
    }
    public static Ventes ToEntite(VenteDTO venteDTO){
        if(venteDTO==null){
            return null;
        }
        Ventes ventes=new Ventes();
        ventes.setId(venteDTO.getId());
        ventes.setCode(venteDTO.getCode());
        ventes.setCommentaire(venteDTO.getCommentaire());
        ventes.setIdentreprise(venteDTO.getIdentreprise());
        return ventes;
    }
}
