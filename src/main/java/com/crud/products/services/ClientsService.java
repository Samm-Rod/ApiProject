package com.crud.products.services;

import com.crud.products.entities.Clients;
import com.crud.products.entities.Messages;
import com.crud.products.entities.Products;
import com.crud.products.reposotories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    @Autowired
    private Messages msg;
    @Autowired
    private ClientsRepository cr;

    public ResponseEntity<?> createClient(Clients client){
        if(client.getC_name().equals("")){
            msg.setMessage("Invalid Name !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(client.getEmail().equals("")){
            msg.setMessage("Invalid Email !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(client.getContact().equals("")){
            msg.setMessage("Invalid Contact !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else if(client.getAddress().equals("")){
            msg.setMessage("Invalid Address !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(cr.save(client),HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> listClients(){
        return new ResponseEntity<>(cr.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listClientsById(long id){
        if(id <= 0){
            msg.setMessage("Invalid Name !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cr.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<?> updateById(Clients obj){
        if(cr.countById(obj.getId()) == 0){
            msg.setMessage("Not Found Client !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cr.save(obj), HttpStatus.OK);
    }

    public ResponseEntity<?> removeById(int id){
        if(cr.countById(id) == 0){
            msg.setMessage("Not Found Client !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        Clients obj = cr.findById(id);
        msg.setMessage("Client Deleted !");
        cr.delete(obj);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }




}
