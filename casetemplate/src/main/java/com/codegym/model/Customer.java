package com.codegym.model;

public class Customer {
    private long id;
    private String name;
    private String address;
    private String telephone;


    private ECustomerType eCustomerType;

    public Customer() {
    }
    public Customer(long id, String name, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ECustomerType geteCustomerType() {
        return eCustomerType;
    }

    public void seteCustomerType(ECustomerType eCustomerType) {
        this.eCustomerType = eCustomerType;
    }
}