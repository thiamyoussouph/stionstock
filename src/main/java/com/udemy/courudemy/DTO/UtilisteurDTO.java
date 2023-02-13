package com.udemy.courudemy.DTO;


import com.udemy.courudemy.Enteties.Adresse;
import com.udemy.courudemy.Enteties.Utilisateur;
import lombok.Builder;
import lombok.Data;


import javax.persistence.Embedded;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisteurDTO {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String photo;
    private boolean actived;

    private EntrepriseDTO entreprises;

    private Adresse adresse;

    private List<RoleDTO> roles;
        public static UtilisteurDTO fromEntity(Utilisateur utilisateur){
        if(utilisateur==null){
            return null;
        }
        return UtilisteurDTO.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .photo(utilisateur.getPhoto())
                .actived(utilisateur.isActived())
                .adresse(utilisateur.getAdresse())
                .entreprises(EntrepriseDTO.fromEntity(utilisateur.getEntreprises()))
                .roles(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RoleDTO::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
        }
            public static Utilisateur toEntity(UtilisteurDTO utilisateurDTO){
        if(utilisateurDTO==null){
            return null;
        }
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setId(utilisateurDTO.getId());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setEmail(utilisateurDTO.getEmail());
        utilisateur.setMotDePasse(utilisateurDTO.getMotDePasse());
        utilisateur.setPhoto(utilisateurDTO.getPhoto());
        utilisateur.setActived(utilisateurDTO.isActived());
        utilisateur.setAdresse(utilisateurDTO.getAdresse());
        utilisateur.setEntreprises(EntrepriseDTO.toEntity(utilisateurDTO.getEntreprises()));
           utilisateur.setRoles(
                    utilisateurDTO.getRoles() != null ?
                            utilisateurDTO.getRoles().stream()
                                    .map(RoleDTO::toEntity)
                                    .collect(Collectors.toList()) : null
            );
        return utilisateur;

            }

}
