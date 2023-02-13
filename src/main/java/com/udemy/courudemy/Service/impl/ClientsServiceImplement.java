package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.ClientDTO;
import com.udemy.courudemy.Service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ClientsServiceImplement implements ClientService {
    @Override
    public ClientDTO save(ClientDTO dto) {
        return null;
    }

    @Override
    public ClientDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<ClientDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
