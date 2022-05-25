/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Bisso
 */
public class Room {
    private int Number;
    private int Price;
    private String type;
    private int HospitalID;

    public Room() {
    }

    public Room(int Number, int Price, String type, int HospitalID) {
        this.Number = Number;
        this.Price = Price;
        this.type = type;
        this.HospitalID = HospitalID;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHospitalID(int HospitalID) {
        this.HospitalID = HospitalID;
    }

    public int getNumber() {
        return Number;
    }

    public int getPrice() {
        return Price;
    }

    public String getType() {
        return type;
    }

    public int getHospitalID() {
        return HospitalID;
    }
    
}
