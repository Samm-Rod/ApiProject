package com.crud.products.controller;

import com.crud.products.entities.Clients;
import com.crud.products.entities.Itens;
import com.crud.products.entities.Products;
import com.crud.products.services.ClientsService;
import com.crud.products.services.ItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// New Class Itens
@RestController
@RequestMapping("/itens")
public class ItensController {
    @Autowired
    private ItensService itensService;
    @PostMapping("/create")
    public ResponseEntity<?> createClients(@RequestBody Itens obj){
        return itensService.createItens(obj);
    }
    @GetMapping("/list")
    public ResponseEntity<?> listItem(){
        return itensService.listItens();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listById(@PathVariable long id){
        return itensService.listItensById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClient(@RequestBody Itens obj){
        return itensService.updateById(obj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable int id){
        return itensService.removeById(id);
    }



}
