package com.example.farmerpriceapp;

public class FarmerSellingItems {
    String farmername;
    String item;
    String quantity;
    double TotalAmount;

    public FarmerSellingItems(String farmername, String item, String quantity, String totalAmount) {
        this.farmername = farmername;
        this.item = item;
        this.quantity = quantity;
        TotalAmount = Double.parseDouble(totalAmount);
    }

    public String getFarmername() {
        return farmername;
    }

    public String getItem() {
        return item;
    }

    public String getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }
}
