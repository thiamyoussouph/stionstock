package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.EntrepriseDTO;
import com.udemy.courudemy.Repository.EntrepriseRepository;
import com.udemy.courudemy.Service.EntrepriseService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImplement implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    public EntrepriseServiceImplement(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }
    @Override
    public EntrepriseDTO save(EntrepriseDTO dto) {
     List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entreprise is not valid {}", dto);
            throw new InvalidEntityException("Entreprise is not valid", CodeEror.ENTREPRISE_NOT_VALID, errors);
        }
        return EntrepriseDTO.fromEntity(entrepriseRepository.save(EntrepriseDTO.toEntity(dto)));

    }

    @Override
    public EntrepriseDTO findById(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return null;
        }
        return EntrepriseDTO.fromEntity(entrepriseRepository.findById(id)
                .orElseThrow(() -> new InvalidEntityException("No Entreprise with ID = " + id + "was found in the DB", CodeEror.ENTREPRISE_NOT_FOUND)));
    }

    @Override
    public List<EntrepriseDTO> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDTO::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}

