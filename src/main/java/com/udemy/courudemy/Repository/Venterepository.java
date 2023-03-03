package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Venterepository extends JpaRepository<Ventes, Integer> {

    Optional<Ventes> findByCode(String code);
}
