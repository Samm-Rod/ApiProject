package com.crud.products;

import com.crud.products.entities.Products;
import com.crud.products.reposotories.ProductsRepositories;
import com.crud.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    @Autowired
    private ProductsService pServ;

    @PostMapping("/prods")
    public ResponseEntity<?> insertProduct(@RequestBody Products obj){
        return pServ.register(obj);
    }

    @GetMapping("/prods")
    public ResponseEntity<?> listProducts(){
        return pServ.listProduct();
    }

    @GetMapping("/prods/{id}")
    public ResponseEntity<?> searchProducts(@PathVariable int id){
        return pServ.searchProduct(id);
    }

    @PutMapping("/prods")
    public ResponseEntity<?> updateProducts(@RequestBody Products obj){
        return pServ.updates(obj);
    }

    @DeleteMapping("/prods/{id}")
    public ResponseEntity<?> removeProducts(@PathVariable int id){
        return pServ.remove(id);
    }
}
