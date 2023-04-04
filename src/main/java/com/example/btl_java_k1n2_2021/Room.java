package com.example.btl_java_k1n2_2021;

import java.io.Serializable;

public class Room implements Serializable {
    private String roomId;
    private int numberOfBed;

    public Room() {
        this("",0);
    }

    public Room(String roomId,int numberOfBed) {
        this.roomId = roomId;
        this.numberOfBed = numberOfBed;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

}