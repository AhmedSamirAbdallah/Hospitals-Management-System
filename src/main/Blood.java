/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Bisso
 */
public class Blood {
    private String Type;
    private int Count;
    private int HospitalID;

    public Blood(String Type, int Count, int HospitalID) {
        this.Type = Type;
        this.Count = Count;
        this.HospitalID = HospitalID;
    }

    public Blood() {
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public void setHospitalID(int HospitalID) {
        this.HospitalID = HospitalID;
    }

    public String getType() {
        return Type;
    }

    public int getCount() {
        return Count;
    }

    public int getHospitalID() {
        return HospitalID;
    }
    
}
