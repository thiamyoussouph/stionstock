package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.CommandeClientDTO;
import com.udemy.courudemy.DTO.LigneCommandeClientDTO;
import com.udemy.courudemy.Enteties.Client;
import com.udemy.courudemy.Enteties.CommandeClients;
import com.udemy.courudemy.Enteties.LigneCommandeclients;
import com.udemy.courudemy.Repository.ArticleRepository;
import com.udemy.courudemy.Repository.ClientRepository;
import com.udemy.courudemy.Repository.CommandeClientRepository;
import com.udemy.courudemy.Repository.LignecomandeclientRepository;
import com.udemy.courudemy.Service.CommandeClientService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.CommandeClienyvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientImplement implements CommandeClientService {
    private CommandeClientRepository commandeClientRepository;
    private LignecomandeclientRepository lignecomandeclientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    public CommandeClientImplement(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository, LignecomandeclientRepository lignecomandeclientRepository) {
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.commandeClientRepository = commandeClientRepository;
        this.lignecomandeclientRepository = lignecomandeclientRepository;
    }

    @Override
    public CommandeClientDTO save(CommandeClientDTO dto) {
        List<String> errors = CommandeClienyvalidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Client is not valid", CodeEror.CLent_IS_NOT_VALID, errors);

        }
        Optional<Client> client = clientRepository.findById((int) dto.getClient().getId());
        if(client.isEmpty()){
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Client is not valid", CodeEror.CLIENT_NOT_VALID, errors);
        }
       if (dto.getDateCommandeClient()!=null){
           dto.getLigneCommandeClients().forEach(ligneCommandeClientDTO -> {
               if (ligneCommandeClientDTO.getArticle()!=null){
                   if (articleRepository.findById((int) ligneCommandeClientDTO.getArticle().getId()).isEmpty()){
                       errors.add("L'article avec l'ID = " + ligneCommandeClientDTO.getArticle().getId() + " n'existe pas dans la BDD");
                   }
               }else {
                   errors.add("Impossible de d'ajouter une ligne de commande sans article");
               }
           });
       }
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("Client is not valid", CodeEror.Ceclient_neciste_pas, errors);
        }
        CommandeClients savecoamdeclient = commandeClientRepository.save(CommandeClientDTO.ToEntite(dto));
        dto.getLigneCommandeClients().forEach(ligcmdcl -> {
            LigneCommandeclients ligneCommandeclients = LigneCommandeClientDTO.toEntity(ligcmdcl);
            ligneCommandeclients.setCommandeClients(savecoamdeclient );
            lignecomandeclientRepository.save(ligneCommandeclients);


        });
        return CommandeClientDTO.fromEntity(savecoamdeclient);


    }

    @Override
    public CommandeClientDTO findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }

        return commandeClientRepository.findById(id)
                .map(CommandeClientDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("No Client with ID = " + id + "was found in the DB", CodeEror.CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDTO findByCode(String code) {
       if(StringUtils.hasLength(code)){
              log.error("Client code is null");
       return null;
       }


    return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("pas de client apes le = " + code + "nexiste pas dans la base de donéés", CodeEror.CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDTO> findAll() {

        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        commandeClientRepository.deleteById(id);

    }
}
