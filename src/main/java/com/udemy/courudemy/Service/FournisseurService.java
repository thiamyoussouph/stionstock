package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.FourniseurDTO;

import java.util.List;

public interface FournisseurService {
    FourniseurDTO save(FourniseurDTO dto);
    FourniseurDTO findById(Integer id);
    List<FourniseurDTO> findAll();
    void delete(Integer id);

}
