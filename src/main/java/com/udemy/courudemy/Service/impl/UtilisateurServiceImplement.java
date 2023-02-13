package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.UtilisteurDTO;
import com.udemy.courudemy.Repository.UtilisateurRepository;
import com.udemy.courudemy.Service.UtilisateurService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.Utilisateurvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImplement implements UtilisateurService {
private UtilisateurRepository utilisateurRepository;
@Autowired
public UtilisateurServiceImplement(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public UtilisteurDTO save(UtilisteurDTO dto) {
    List<String> errors = Utilisateurvalidator.validate(dto);
    if(!errors.isEmpty()){
        log.error("Utilisateur is not valid {}",dto);
        throw new InvalidEntityException("Utilisateur is not valid", CodeEror.UTILISATEUR_NOT_VALID,errors);
    }
        return UtilisteurDTO.fromEntity(utilisateurRepository.save(UtilisteurDTO.toEntity(dto)));
    }

    @Override
    public UtilisteurDTO findById(Integer id) {
        if(id == null){
            log.error("Utilisateur ID is null");
            throw new InvalidEntityException("Utilisateur ID is null", CodeEror.UTILISATEUR_NOT_VALID);
        }
        return UtilisteurDTO.fromEntity(utilisateurRepository.findById(id).orElseThrow(() -> new InvalidEntityException("No Utilisateur with ID = " + id + "was found in the DB", CodeEror.UTILISATEUR_NOT_VALID)));
    }

    @Override
    public List<UtilisteurDTO> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisteurDTO::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Utilisateur ID is null");
            throw new InvalidEntityException("Utilisateur ID is null", CodeEror.UTILISATEUR_NOT_VALID);
        }
        utilisateurRepository.deleteById(id);

    }
}

