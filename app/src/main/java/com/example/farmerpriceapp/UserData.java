package com.example.farmerpriceapp;

public class UserData {
    String farmername,village,area;

    public UserData() {
    }

    public UserData(String farmername, String village, String area) {
        this.farmername = farmername;
        this.village = village;
        this.area = area;
    }

    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
