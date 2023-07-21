package com.crud.products.reposotories;

import com.crud.products.entities.Itens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItensRepository extends JpaRepository<Itens, Long> {

    List<Itens> findAll();
    Itens findById(long id);
    long countById(long id);


}
