package com.example.webflux.dao.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("inventory.orders")
@Data
public class Order {
    @Id
    @Column("order_number")
    public Integer orderNumber;

    @Column("order_date")
    @JsonFormat(pattern="dd/MM/yyyy")
    public Date orderDate;

    @Column("purchaser")
    public int purchaser;

    @Column("quantity")
    public int quantity;

    @Column("product_id")
    public int productId;

}