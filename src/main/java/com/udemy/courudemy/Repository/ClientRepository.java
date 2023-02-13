package com.udemy.courudemy.Repository;

import com.udemy.courudemy.Enteties.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
