package com.ute.ecwebapp.beans;

public class Product {
    private int ProID,Price, CatID, Quantity;
    private String ProName, TinyDes, FullDes;

    public Product(int proID, int price, int catID, int quantity, String proName, String tinyDes, String fullDes) {
        ProID = proID;
        Price = price;
        CatID = catID;
        Quantity = quantity;
        ProName = proName;
        TinyDes = tinyDes;
        FullDes = fullDes;
    }

    public Product() {
    }

    public int getProID() {
        return ProID;
    }

    public int getPrice() {
        return Price;
    }

    public int getCatID() {
        return CatID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getProName() {
        return ProName;
    }

    public String getTinyDes() {
        return TinyDes;
    }

    public String getFullDes() {
        return FullDes;
    }
}
