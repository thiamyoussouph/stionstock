package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.CategoriDTO;
import com.udemy.courudemy.Repository.CategoriReposiory;
import com.udemy.courudemy.Service.CategoryServices;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.CathegoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoriServiceImplement implements CategoryServices {
    private CategoriReposiory categoriReposiory;
    public CategoriServiceImplement(CategoriReposiory categoriReposiory) {
        this.categoriReposiory = categoriReposiory;
    }
    @Override
    public CategoriDTO save(CategoriDTO dto) {
        List<String> errors = CathegoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Categori is not valid {}", dto);
            throw new InvalidEntityException("Categori is not valid", CodeEror.CATEGORY_NOT_FOUNDEROR.CATEGORY_NOT_VALID, errors);
        }
        return CategoriDTO.fromEntity(categoriReposiory.save(CategoriDTO.ToEntite(dto)));
    }

    @Override
    public CategoriDTO findById(Integer id) {
        if (id == null) {
            log.error("Categori ID is null");
            return null;
        }
        return categoriReposiory.findById(id)
                .map(CategoriDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("No Categori with ID = " + id + "was found in the DB", CodeEror.CATEGORY_NOT_FOUNDEROR));
    }

    @Override
    public CategoriDTO findByCode(String code) {
        if (code == null) {
            log.error("Categori ID is null");
            return null;
        }
        return categoriReposiory.findCategoryByCode(code)
                .map(CategoriDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("No Categori with ID = " + code + "was found in the DB", CodeEror.CATEGORY_NOT_FOUNDEROR));
    }

    @Override
    public List<CategoriDTO> findAll() {

        return categoriReposiory.findAll().stream()
                .map(CategoriDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Categori ID is null");
            return;
        }
        categoriReposiory.deleteById(id);

    }

}
