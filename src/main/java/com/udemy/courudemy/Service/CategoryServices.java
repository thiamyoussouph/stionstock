package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.CategoriDTO;

import java.util.List;

public interface CategoryServices {

    CategoriDTO save(CategoriDTO dto);
    CategoriDTO findById(Integer id);
    CategoriDTO findByCode(String code);
    List<CategoriDTO> findAll();
    void delete(Integer id);
}
