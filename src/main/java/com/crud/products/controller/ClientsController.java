package com.crud.products.controller;

import com.crud.products.entities.Clients;
import com.crud.products.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping("/create")
    public ResponseEntity<?> createClients(@RequestBody Clients clients){
        return clientsService.createClient(clients);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listUsers(){
        return clientsService.listClients();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listById(@PathVariable long id){
        return clientsService.listClientsById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClient(@RequestBody Clients obj){
        return clientsService.updateById(obj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable int id){
        return clientsService.removeById(id);
    }
}
