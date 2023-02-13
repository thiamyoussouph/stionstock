package com.udemy.courudemy.validateurs;

import com.udemy.courudemy.DTO.UtilisteurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Utilisateurvalidator {
    public static List<String> validate(UtilisteurDTO utilisateurDTO){
        List<String> errors = new ArrayList<>();
        if(utilisateurDTO == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
            errors.add("Veuillez renseigner le email de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner le identreprise de l'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDTO.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDTO.getPrenom())){
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDTO.getEmail())){
            errors.add("Veuillez renseigner le email de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDTO.getMotDePasse())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        if(utilisateurDTO.getEntreprises()==null){
            errors.add("Veuillez renseigner le identreprise de l'utilisateur");
        }
        if (utilisateurDTO.getRoles()==null){
            errors.add("Veuillez renseigner le role de l'utilisateur");
        }
        if (utilisateurDTO.getAdresse()==null){
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");

        }
        else {
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getAdress1())){
                errors.add("Veuillez renseigner l'adresse1 de l'utilisateur");
            }
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getAdress2())){
                errors.add("Veuillez renseigner l'adresse2 de l'utilisateur");
            }
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getVille())){
                errors.add("Veuillez renseigner la ville de l'utilisateur");
            }
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getPays())){
                errors.add("Veuillez renseigner le pays de l'utilisateur");
            }
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getCodePostal())){
                errors.add("Veuillez renseigner le code postal de l'utilisateur");
            }
        }
        return errors;
    }


}
