package com.crud.products.controller;

import com.crud.products.entities.Products;
import com.crud.products.reposotories.ProductsRepositories;
import com.crud.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prods")
public class ProductController {
    @Autowired
    private ProductsService pServ;

    @PostMapping("/create")
    public ResponseEntity<?> insertProduct(@RequestBody Products obj){
        return pServ.register(obj);
    }

    @GetMapping("/lists")
    public ResponseEntity<?> listProducts(){
        return pServ.listProduct();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> searchProducts(@PathVariable int id){
        return pServ.searchProduct(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProducts(@RequestBody Products obj){
        return pServ.updates(obj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeProducts(@PathVariable int id){
        return pServ.remove(id);
    }
}
