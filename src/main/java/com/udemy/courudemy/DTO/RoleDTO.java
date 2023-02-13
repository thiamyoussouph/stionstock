package com.udemy.courudemy.DTO;

import com.udemy.courudemy.Enteties.Roles;
import com.udemy.courudemy.Enteties.Utilisateur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
@Builder
public class RoleDTO {
    private long id;
    private String roleName;

    private UtilisteurDTO utilisateur;
        public static RoleDTO fromEntity(Roles role){
        if(role==null){
            return null;
        }
        return RoleDTO.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .utilisateur(UtilisteurDTO.fromEntity(role.getUtilisateur()))
                .build();
        }
        public static Roles toEntity(RoleDTO roleDTO){
        if(roleDTO==null){
            return null;
        }
        Roles role=new Roles();
        role.setId(roleDTO.getId());
        role.setRoleName(roleDTO.getRoleName());
        role.setUtilisateur(UtilisteurDTO.toEntity(roleDTO.getUtilisateur()));
        return role;
        }
}
