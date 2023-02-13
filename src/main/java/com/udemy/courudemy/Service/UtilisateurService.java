package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.UtilisteurDTO;

import java.util.List;

public interface UtilisateurService {
    UtilisteurDTO save(UtilisteurDTO dto);
    UtilisteurDTO findById(Integer id);
    List<UtilisteurDTO> findAll();
    void delete(Integer id);
}

