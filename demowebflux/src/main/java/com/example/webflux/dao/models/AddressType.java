package com.example.webflux.dao.models;

public enum AddressType {
    SHIPPING("Shipping"),
    BILLING("Billing"),
    LIVING("Living");

    private String descricao;

    private AddressType(String descricao) {

        this.descricao = descricao;

    }

}