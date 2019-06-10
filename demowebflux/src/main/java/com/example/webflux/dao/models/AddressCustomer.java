package com.example.webflux.dao.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
public class AddressCustomer {



// ADDRESS

    public Integer idAddress;


    public Integer customerId;


    public String street;


    public String city;


    public String state;


    public String zip;


    public String type;




    //  CUSTOMERS

    private String firstName;


    private String lastName;


    private String email;
}
