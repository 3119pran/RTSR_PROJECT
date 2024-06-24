package com.example.farmerpriceapp;

public class Order {
    String id;
    String itemname;
    String productprice;
    String productcost;


    public Order(String id, String itemname, String productprice, String productcost) {
        this.id = id;
        this.itemname = itemname;
        this.productprice = productprice;
        this.productcost = productcost;

    }

    public String getId() {
        return id;
    }

    public String getItemname() {
        return itemname;
    }

    public String getProductprice() {
        return productprice;
    }

    public String getProductcost() {
        return productcost;
    }

}
