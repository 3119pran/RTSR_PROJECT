package com.example.farmerpriceapp;

public class Farmer {
    String farmername;
    String area;
    String Village;

    public Farmer(String farmername, String area, String village) {
        this.farmername = farmername;
        this.area = area;
        Village = village;
    }

    public String getFarmername() {
        return farmername;
    }

    public String getArea() {
        return area;
    }

    public String getVillage() {
        return Village;
    }
}
