package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.CommandeFournisseurDTO;

public interface CommandeFornisuerService {
    CommandeFournisseurDTO save(CommandeFournisseurDTO dto);
    CommandeFournisseurDTO findById(Integer id);
    CommandeFournisseurDTO findCommandefourniseurByCode(String code);
    void delete(Integer id);

}
