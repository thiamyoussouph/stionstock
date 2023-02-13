package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.FourniseurDTO;
import com.udemy.courudemy.Repository.FournisseurRepository;
import com.udemy.courudemy.Service.FournisseurService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImplement implements FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    public FournisseurServiceImplement(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public FourniseurDTO save(FourniseurDTO dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Fournisseur is not valid {}",dto);
            throw new InvalidEntityException("Fournisseur is not valid", CodeEror.FOURNISSEUR_NOT_VALID,errors);

        }
        return FourniseurDTO.fromEntity(fournisseurRepository.save(FourniseurDTO.toEntity(dto)));
    }

    @Override
    public FourniseurDTO findById(Integer id) {
        if(id == null){
            log.error("Fournisseur ID is null");
            throw new InvalidEntityException("Fournisseur ID is null", CodeEror.FOURNISSEUR_NOT_VALID);
        }
        return  FourniseurDTO.fromEntity(fournisseurRepository.findById(id).orElseThrow(() -> new InvalidEntityException("No Fournisseur with ID = " + id + "was found in the DB", CodeEror.FOURNISSEUR_NOT_VALID)));
    }

    @Override
    public List<FourniseurDTO> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FourniseurDTO::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Fournisseur ID is null");
            throw new InvalidEntityException("Fournisseur ID is null", CodeEror.FOURNISSEUR_NOT_VALID);
        }
        fournisseurRepository.deleteById(id);

    }


}
