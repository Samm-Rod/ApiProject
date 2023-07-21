package com.crud.products.reposotories;

import com.crud.products.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

    List<Clients> findAll();
    Clients findById(long id);
    @Query("")
    long countById(long id);
}
