package com.example.btl_java_k1n2_2021;

import java.io.Serializable;

public class Customer implements Serializable {
    private String identity;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Customer() {
        this("","","","");
    }

    public Customer(String identity, String customerName, String email, String phoneNumber) {
        this.identity = identity;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}