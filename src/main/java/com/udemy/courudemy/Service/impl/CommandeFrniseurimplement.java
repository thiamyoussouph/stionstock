package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.CommandeFournisseurDTO;
import com.udemy.courudemy.DTO.LigneCommandeClientDTO;
import com.udemy.courudemy.DTO.LigneCommandeFourniseurDTO;
import com.udemy.courudemy.Enteties.Article;
import com.udemy.courudemy.Enteties.Commandefourniseur;
import com.udemy.courudemy.Enteties.Fournisseurs;
import com.udemy.courudemy.Enteties.LigneCommandefournisseur;
import com.udemy.courudemy.Repository.ArticleRepository;
import com.udemy.courudemy.Repository.CommandeFournisuerrepository;
import com.udemy.courudemy.Repository.FournisseurRepository;
import com.udemy.courudemy.Repository.LigneCommandefournisseurRepository;
import com.udemy.courudemy.Service.CommandeFornisuerService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.CommandefourniseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class CommandeFrniseurimplement  implements CommandeFornisuerService{
    private CommandeFournisuerrepository commandeFournisuerrepository;
    private FournisseurRepository fournisseurRepository;
    private LigneCommandefournisseurRepository ligneCommandefournisseurRepository;
    @Autowired
    private ArticleRepository articleRepository;
    public CommandeFrniseurimplement(CommandeFournisuerrepository commandeFournisuerrepository, LigneCommandefournisseurRepository ligneCommandefournisseurRepository, ArticleRepository articleRepository, FournisseurRepository fournisseurRepository) {
        this.commandeFournisuerrepository = commandeFournisuerrepository;
        this.ligneCommandefournisseurRepository = ligneCommandefournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeFournisseurDTO save(CommandeFournisseurDTO dto) {
        List<String> errors = CommandefourniseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("CommandeFournisseur is not valid {}", dto);
            throw new InvalidEntityException("La commande fournisseur n'est pas valide", CodeEror.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }
        Optional<Fournisseurs>fournisseurs= fournisseurRepository.findById((int) dto.getFournisseurs().getId());
        if (fournisseurs.isEmpty()) {
            log.warn("Fournisseur ID {} does not exist in the BDD", dto.getFournisseurs().getId());
            throw new InvalidEntityException("Fournisseur n'existe pas", CodeEror.FOURNISSEUR_NOT_FOUND);
        }
        List<String> articleErrors =new ArrayList<>();
        if (dto.getLigneCommandefournisseurs() !=null){
            dto.getLigneCommandefournisseurs().forEach(ligncf -> {
                if (ligncf.getArticle() !=null){
                  Optional<Article> article = articleRepository.findById((int) ligncf.getArticle().getId());
                    if (article.isEmpty()){
                        articleErrors.add("L'article avec l'ID " + ligncf.getArticle().getId() + " n'existe pas");
                    }else   {
                        articleErrors.add("L'article avec l'ID " + ligncf.getArticle().getId() + " n'existe pas");
                    }
                }

            });

        }
        if (!articleErrors.isEmpty()){
            throw new InvalidEntityException("Une ou plusieurs erreurs ont été rencontrées lors de la validation des articles", CodeEror.ARTICLE_NOT_FOUND, articleErrors);
        }
        Commandefourniseur savedCommandeFournisseur = commandeFournisuerrepository.save(CommandeFournisseurDTO.toEntity(dto));
        if (dto.getLigneCommandefournisseurs() !=null){
            dto.getLigneCommandefournisseurs().forEach(ligncf -> {
                LigneCommandefournisseur lignecomandeforniseur= LigneCommandeFourniseurDTO.toEntity(ligncf);
                lignecomandeforniseur.setCommandefourniseur(savedCommandeFournisseur);
                ligneCommandefournisseurRepository.save(lignecomandeforniseur);
            });
        }
        return CommandeFournisseurDTO.fromEntity(savedCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDTO findById(Integer id) {
        if (id == null) {
            log.error("CommandeFournisseur ID is null");
            return null;
        }
        return commandeFournisuerrepository.findById(id)
                .map(CommandeFournisseurDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("Aucune commande fournisseur avec l'ID = " + id + " n'a été trouvé dans la BDD", CodeEror.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDTO findCommandefourniseurByCode(String code) {
        if (code == null) {
            log.error("CommandeFournisseur code is null");
            return null;
        }
        return commandeFournisuerrepository.findCommandefourniseurByCode(code)
                .map(CommandeFournisseurDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("Aucune commande fournisseur avec le code = " + code + " n'a été trouvé dans la BDD", CodeEror.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public void delete(Integer id) {

    }
}
