package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByCode(String codearticle);


    List<Article> findByCategoriId( Integer id);
}
