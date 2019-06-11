package com.example.webflux.dao.models;

public class ProductDTO {


    public String name;


    public String description;


    public Float weight;

    public Product transformaParaObjeto(){
        return new Product(name,description,weight);
    }
}
