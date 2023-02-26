package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.ClientDTO;
import com.udemy.courudemy.Repository.ClientRepository;
import com.udemy.courudemy.Service.ClientService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.ClientsValiator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientsServiceImplement implements ClientService {
    private ClientRepository clientRepository;
    public ClientsServiceImplement(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public ClientDTO save(ClientDTO dto) {
        List<String> errors = ClientsValiator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Client is not valid", CodeEror.CLIENT_NOT_VALID, errors);

        }

        return  ClientDTO.fromEntity(clientRepository.save(ClientDTO.toEntity(dto))) ;
    }

    @Override
    public ClientDTO findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }

        return clientRepository.findById(id)
                .map(ClientDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("No Client with ID = " + id + "was found in the DB", CodeEror.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
if (id == null) {
            log.error("Client ID is null");
            return;
        }
        clientRepository.deleteById(id);
    }
}
