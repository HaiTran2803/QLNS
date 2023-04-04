package com.example.btl_java_k1n2_2021;

import java.io.Serializable;

public class Booking  implements Serializable {
    private String roomID;
    private Customer customer;

    public Booking(String roomID, Customer customer){
        this.roomID = roomID;
        this.customer = customer;
    }

    public String getRoomID(){
        return roomID;
    }

    public Customer getCustomer(){
        return customer;
    }

}

