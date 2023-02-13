package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.CommandeClients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository  extends JpaRepository<CommandeClients, Integer> {


}
