package com.crud.products.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "product")
    private List<Clients> clients = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "products_id")
    @JsonManagedReference
    private List<Itens> itens = new ArrayList<>();

}
