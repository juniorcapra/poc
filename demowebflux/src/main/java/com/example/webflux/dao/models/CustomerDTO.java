package com.example.webflux.dao.models;

public class CustomerDTO {



    public String firstName;


    public String lastName;


    public String email;

    public Customer transformaParaObjeto(){
        return new Customer(firstName,lastName,email);
    }
}
