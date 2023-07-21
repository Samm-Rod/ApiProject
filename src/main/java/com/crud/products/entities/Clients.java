package com.crud.products.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String c_name;
    private String email;
    private String contact;
    private String address;
    @ManyToMany
    @JoinTable(name = "clients_products",
    joinColumns = {@JoinColumn(name = "clients_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "products_id", referencedColumnName = "id")})
    private List<Products> product = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "clients_id")
    @JsonManagedReference
    private List<Itens> itens = new ArrayList<>();



}
