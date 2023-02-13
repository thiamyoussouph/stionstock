package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.Entreprises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprises, Integer> {

}

