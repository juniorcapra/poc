package com.example.webflux.dao.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("products_on_hand")
public class ProductOnHand {
    @Id
    @Column("product_id")
    public Integer productId;

    @Column("quantity")
    public Integer quantity;

}