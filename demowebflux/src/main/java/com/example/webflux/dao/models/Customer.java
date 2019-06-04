package com.example.webflux.dao.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("customers")
public class Customer {
    @Id
    public Integer id;

    @Column("first_name")
    public String firstName;

    @Column("last_name")
    public String lastName;

    @Column("email")
    public String email;

}