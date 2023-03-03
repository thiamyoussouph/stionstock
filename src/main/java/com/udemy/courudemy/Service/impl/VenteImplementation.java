package com.udemy.courudemy.Service.impl;

import com.udemy.courudemy.DTO.LigneVenteDTO;
import com.udemy.courudemy.DTO.VenteDTO;
import com.udemy.courudemy.Enteties.Article;
import com.udemy.courudemy.Enteties.Lignevente;
import com.udemy.courudemy.Enteties.Ventes;
import com.udemy.courudemy.Repository.ArticleRepository;
import com.udemy.courudemy.Repository.LigneventeRepository;
import com.udemy.courudemy.Repository.Venterepository;
import com.udemy.courudemy.Service.VenteService;
import com.udemy.courudemy.exeption.CodeEror;
import com.udemy.courudemy.exeption.InvalidEntityException;
import com.udemy.courudemy.validateurs.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VenteImplementation implements VenteService {
    private ArticleRepository articleRepository;
    Venterepository venterepository;
    LigneventeRepository ligneventeRepository;
    @Autowired
    public VenteImplementation(ArticleRepository articleRepository, Venterepository venterepository, LigneventeRepository ligneventeRepository) {
        this.articleRepository = articleRepository;
        this.venterepository = venterepository;
        this.ligneventeRepository = ligneventeRepository;
    }


    @Override
    public VenteDTO save(VenteDTO dto) {
        List<String> errors = VenteValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Vente non valide {}", dto);
            throw new InvalidEntityException("La vente n'est pas valide", CodeEror.VENTE_NOT_VALID, errors);
        }
        List<String> ArticleErrors = new ArrayList<>();
        dto.getLigneventes().forEach(ligneVenteDTO -> {
            Optional<Article> article = articleRepository.findById((int) ligneVenteDTO.getArticle().getId());
            if (article.isEmpty()) {
                ArticleErrors.add("Aucun article avec l'ID " + ligneVenteDTO.getArticle().getId() + "n'a été trouvé dans la BDD");
            }
        });
        if (!ArticleErrors.isEmpty()) {
            log.error("Vente non valide {}", dto);
            throw new InvalidEntityException("La vente n'est pas valide", CodeEror.VENTE_NOT_VALID, ArticleErrors);
        }
        Ventes savedVente = venterepository.save(VenteDTO.ToEntite(dto));
        dto.getLigneventes().forEach(ligneVenteDTO -> {
            Lignevente lignevente= LigneVenteDTO.toEntity(ligneVenteDTO);
            lignevente.setVente(savedVente);
            ligneventeRepository.save(lignevente);
        });
        return VenteDTO.fromEntity(savedVente);
    }

    @Override
    public VenteDTO findById(Integer id) {
        if (id == null){
            log.error("Vente ID is null");
            return null;
        }

        return venterepository.findById(id)
                .map(VenteDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("Aucune vente avec l'ID = " + id + "n'a été trouvé dans la BDD", CodeEror.VENTE_NOT_FOUND));
    }

    @Override
    public VenteDTO findByCode(String code) {
if (code == null){
            log.error("Vente code is null");
            return null;
        }
        return venterepository.findByCode(code)
                .map(VenteDTO::fromEntity)
                .orElseThrow(() -> new InvalidEntityException("Aucune vente avec le code = " + code + "n'a été trouvé dans la BDD", CodeEror.VENTE_NOT_FOUND));

    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Vente ID is null");
            return;
        }
        venterepository.deleteById(id);

    }

    @Override
    public List<VenteDTO> findAll() {
        return venterepository.findAll()
                .stream()
                .map(VenteDTO::fromEntity)
                .toList();

    }
}
