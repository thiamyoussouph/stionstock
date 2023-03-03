package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.VenteDTO;

import java.util.List;

public interface VenteService {
   VenteDTO save(VenteDTO dto);
   VenteDTO findById(Integer id);
    VenteDTO findByCode(String code);
    void delete(Integer id);
    List<VenteDTO> findAll();

}
