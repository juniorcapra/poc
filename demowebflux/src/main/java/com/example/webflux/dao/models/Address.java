package com.example.webflux.dao.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("addresses")
public class Address {

    @Id
    public Integer id;

    @JsonProperty("customer_id")
    @Column("customer_id")
    public Integer customerId;

    @Column("street")
    public String street;

    @Column("city")
    public String city;

    @Column("state")
    public String state;

    @Column("zip")
    public String zip;

    @Column("type")
    public String type;

}