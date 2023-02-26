package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.CommandeClientDTO;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDTO save(CommandeClientDTO dto);
    CommandeClientDTO findById(Integer id);
    CommandeClientDTO findByCode(String code);
    List<CommandeClientDTO> findAll();
    void delete(Integer id);
}
