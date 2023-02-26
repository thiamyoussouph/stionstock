package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.CommandeClients;
import com.udemy.courudemy.Enteties.Commandefourniseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeFournisuerrepository extends JpaRepository<Commandefourniseur, Integer> {
  Optional<Commandefourniseur> findCommandefourniseurByCode(String code);
  List<CommandeClients> findAllByFournisseurs_Id(Integer id);
}
