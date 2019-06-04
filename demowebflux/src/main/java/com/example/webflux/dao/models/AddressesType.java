package com.example.webflux.dao.models;

public enum AddressesType {

 SHIPPING("Shipping"),
 BILLING("Billing"),
 LIVING("Living");


 private String descricao;

 private AddressesType(String descricao) {

  this.descricao = descricao;

 }


}
