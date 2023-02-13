package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.Categori;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriReposiory extends JpaRepository<Categori, Integer> {
    Optional<Categori> findCategoryByCode(String code);

}
