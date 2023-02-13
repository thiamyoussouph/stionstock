package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Article;
import com.udemy.courudemy.Enteties.Categori;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class CategoriDTO {
    private long id;
    private String code;

    private String description;
    private int identreprise;

    private List<ArticleDTO> articles;
    public  static CategoriDTO fromEntity(Categori categori){
        if(categori==null){
            return null;
        }
        return CategoriDTO.builder()
                .id(categori.getId())
                .code(categori.getCode())
                .description(categori.getDescription())
                .identreprise(categori.getIdentreprise())
                .build();
    }
    public static Categori ToEntite( CategoriDTO categoriDTO){
        if(categoriDTO==null){
            return null;
        }
        Categori categori=new Categori();
        categori.setId(categoriDTO.getId());
        categori.setCode(categoriDTO.getCode());
        categori.setDescription(categoriDTO.getDescription());
        categori.setIdentreprise(categoriDTO.getIdentreprise());
        return categori;
    }
}
