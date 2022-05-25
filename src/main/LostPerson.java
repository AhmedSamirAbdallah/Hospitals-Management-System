/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Bisso
 */
public class LostPerson {
    private String Name,Ssn,Gender,Case,Reason,ShirtColor,HairColor,SkinColor,details;
    private int HospitalId , Height;

   
    public LostPerson(String Name, String Ssn, String Gender, String Case, String Reason, int HospitalId, String ShirtColor, String HairColor, String SkinColor, int Height , String details) {
        this(Name,Ssn);
        this.Gender = Gender;
        this.Case = Case;
        this.Reason = Reason;
        this.HospitalId = HospitalId;
        this.ShirtColor = ShirtColor;
        this.HairColor = HairColor;
        this.SkinColor = SkinColor;
        this.Height = Height;
        this.details = details;
    }
    
     public LostPerson(String Name, String Ssn) {
        this.Name = Name;
        this.Ssn = Ssn;
    }

    public LostPerson(){
        this.Name = "";
        this.Ssn = "";
        this.Gender = "";
        this.Case = "";
        this.Reason = "";
        this.ShirtColor = "";
        this.HairColor = "";
        this.SkinColor = "";
        this.details = "";
        this.HospitalId = 0;
        this.Height = 0;
    }
     

    public void setDetails(String details) {
        this.details = details;
    }
    
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSsn(String Ssn) {
        this.Ssn = Ssn;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setCase(String Case) {
        this.Case = Case;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public void setHospitalId(int HospitalId) {
        this.HospitalId = HospitalId;
    }

    public void setShirtColor(String ShirtColor) {
        this.ShirtColor = ShirtColor;
    }

    public void setHairColor(String HairColor) {
        this.HairColor = HairColor;
    }

    public void setSkinColor(String SkinColor) {
        this.SkinColor = SkinColor;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public String getName() {
        return Name;
    }

    public String getSsn() {
        return Ssn;
    }

    public String getGender() {
        return Gender;
    }

    public String getCase() {
        return Case;
    }

    public String getReason() {
        return Reason;
    }

    public int getHospitalId() {
        return HospitalId;
    }

    public String getShirtColor() {
        return ShirtColor;
    }

    public String getHairColor() {
        return HairColor;
    }

    public String getSkinColor() {
        return SkinColor;
    }

    public int getHeight() {
        return Height;
    }

    public String getDetails() {
        return details;
    }

   
    
    
}
