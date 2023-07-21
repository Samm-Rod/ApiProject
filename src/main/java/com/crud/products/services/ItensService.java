package com.crud.products.services;

import com.crud.products.entities.Clients;
import com.crud.products.entities.Itens;
import com.crud.products.entities.Messages;
import com.crud.products.reposotories.ClientsRepository;
import com.crud.products.reposotories.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItensService {

    @Autowired
    private Messages msg;

    @Autowired
    private ItensRepository it;

    public ResponseEntity<?> createItens(Itens obj){
        if(obj.getAmount() <= 0){
            msg.setMessage("No Itens !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        } else if(obj.getDateBuy() == null) {
            msg.setMessage("Inform a date !");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(it.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> listItens(){

        return new ResponseEntity<>(it.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listItensById(long id){
        if(id <= 0){
            msg.setMessage("Not Found Itens !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(it.findById(id),HttpStatus.OK);
    }

    public ResponseEntity<?> updateById(Itens obj){
        if(it.countById(obj.getId()) == 0){
            msg.setMessage("Not Found Client !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(it.save(obj), HttpStatus.OK);
    }

    public ResponseEntity<?> removeById(int id){
        if(it.countById(id) == 0){
            msg.setMessage("Not Found Client !");
            return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        }
        Itens obj = it.findById(id);
        it.delete(obj);
        msg.setMessage("Client Deleted !");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }




}
