package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDTO save(EntrepriseDTO dto);
    EntrepriseDTO findById(Integer id);
    List<EntrepriseDTO> findAll();
    void delete(Integer id);

}
