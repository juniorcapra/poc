package com.example.webflux.dao.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("orders")
public class Order {

    @Id
    @Column("order_number")
    public Integer orderNumber;

    @Column("order_date")
    @JsonFormat(pattern="dd/MM/yyyy")
    public Date orderDate;

    @Column("purchaser")
    public Integer purchaser;

    @Column("quantity")
    public Integer quantity;

    @Column("product_id")
    public Integer productId;




}