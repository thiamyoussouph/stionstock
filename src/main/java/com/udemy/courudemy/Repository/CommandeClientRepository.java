package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.CommandeClients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeClientRepository  extends JpaRepository<CommandeClients, Integer> {
    Optional<CommandeClients> findCommandeClientByCode(String code);

    List<CommandeClients> findAllByClientId(Integer id);

}
