package com.udemy.courudemy.Service;

import com.udemy.courudemy.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO dto);
    ClientDTO findById(Integer id);
    List<ClientDTO> findAll();
    void delete(Integer id);
}

