package com.example.webflux.dao.models;


public class AddressDTO {



    public Integer customerId;


    public String street;


    public String city;


    public String state;


    public String zip;


    public String type;


    public Address transformaParaObjeto(){
        return new Address(customerId,street,city,state,zip,type);
    }
}
