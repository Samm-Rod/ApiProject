package com.crud.products.reposotories;

import com.crud.products.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepositories extends JpaRepository<Products, Long> {

    List<Products> findAll();
    Products findById(int id);



    @Query(value = "")
    long countById(long id);
}
