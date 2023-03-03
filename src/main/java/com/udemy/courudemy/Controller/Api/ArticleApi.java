package com.udemy.courudemy.Controller.Api;


import com.udemy.courudemy.DTO.ArticleDTO;
import com.udemy.courudemy.DTO.LigneCommandeClientDTO;
import com.udemy.courudemy.DTO.LigneCommandeFourniseurDTO;
import com.udemy.courudemy.DTO.LigneVenteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.udemy.courudemy.Controller.Api.utils.Constants.App_ROOT;
@Api(App_ROOT+"/articles")
public interface ArticleApi {
    @PostMapping(value = App_ROOT+"/articles/save", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDTO.class)
   @ApiResponses(value={
            @ApiResponse(code=200, message="L'objet article cree / modifie"),
            @ApiResponse(code=400, message="L'objet article n'est pas valide")

   })
    ArticleDTO save(@RequestBody ArticleDTO dto);
    @GetMapping(value = App_ROOT+"/articles/{id}", produces = "application/json")
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de chercher un article par son ID", response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="L'article a ete trouve dans la BDD"),
            @ApiResponse(code=404, message="Aucun article n'existe dans la BDD avec l'ID fourni")
    })
    ArticleDTO findById(@PathVariable Integer id);
    @GetMapping(value = App_ROOT+"/articles/{codeArticle}", produces = "application/json")
    @ApiOperation(value = "Rechercher un article par code", notes = "Cette methode permet de chercher un article par son code", response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="L'article a ete trouve dans la BDD"),
            @ApiResponse(code=404, message="Aucun article n'existe dans la BDD avec le code fourni")
    })
    ArticleDTO findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
    @GetMapping(value = App_ROOT+"/articles/all", produces = "application/json")
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de chercher et renvoyer la liste des articles qui existent dans la BDD", responseContainer = "List<ArticleDTO>")
    @ApiResponses(value={
            @ApiResponse(code=200, message="La liste des articles / une liste vide")
    })
    List<ArticleDTO> findAll();
    List<LigneVenteDTO>FindsHistoriqueVentes(Integer idArticle);
    List<LigneCommandeClientDTO> findHistoriqueCommandeClient(Integer idArticle);
    List<LigneCommandeFourniseurDTO>fndHistoriqueCommandeFournisseur(Integer idArticle);
    List<ArticleDTO> findAllArticleByIdCategory(Integer idCategory);
    @DeleteMapping(value = App_ROOT+"/articles/{id}")
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article par ID", response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message="L'article a ete supprime")
    })
    void delete(@PathVariable  Integer id);
}
