package com.crud.products.services;

import com.crud.products.entities.Messages;
import com.crud.products.entities.Products;
import com.crud.products.reposotories.ProductsRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepositories pRep;
    @Autowired
    private Messages message;

    // Cadastrar Produto
    public ResponseEntity<?> register(Products obj){
        if(obj.getName().equals("")){
            message.setMessage("Enter a Valid Name !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(obj.getDescription().equals("")){
            message.setMessage("Enter a Valid Description !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(obj.getPrice() < 0){
            message.setMessage("Enter a Valid Price !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pRep.save(obj), HttpStatus.CREATED);
    }

    // Listar todos os produtos
    public ResponseEntity<?> listProduct(){
        return new ResponseEntity<>(pRep.findAll(), HttpStatus.OK);
    }

    // Buscar um produto
    public ResponseEntity<?> searchProduct(int id){
        if(pRep.countById(id) == 0){
            message.setMessage("Product Not Found !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pRep.findById(id),HttpStatus.OK);
    }

    // Atualiza produtos
    public ResponseEntity<?> updates(Products obj){
        if(pRep.countById(obj.getId()) == 0){
            message.setMessage("Invalid Id !");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }else if(obj.getName().equals("")){
            message.setMessage("Invalid Name !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(obj.getDescription().isEmpty()){
            message.setMessage("Description Invalid !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(obj.getPrice() < 0){
            message.setMessage("Price Invalid !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(pRep.save(obj), HttpStatus.OK);
        }
    }

    // Deletar produto
    public ResponseEntity<?> remove(int id){
        if(pRep.countById(id) == 0){
            message.setMessage("Id Invalid !");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        Products prods = pRep.findById(id);
        pRep.delete(prods);
        message.setMessage("Products removed !");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
