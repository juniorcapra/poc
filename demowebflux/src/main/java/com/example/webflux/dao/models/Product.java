package com.example.webflux.dao.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("products")
public class Product {

    @Id
    public Integer id;

    @Column("name")
    public String name;

    @Column("description")
    public String description;

    @Column("weight")
    public Float weight;

    public Product(String name, String description, Float weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
}