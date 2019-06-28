package com.example.webflux.dao.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("customers")
public class Customer {

    @Id
    private Integer id;

    @JsonProperty("first_name")
    @Column("first_name")
    private String firstName;

    @JsonProperty("last_name")
    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Transient
    private Address address;

}