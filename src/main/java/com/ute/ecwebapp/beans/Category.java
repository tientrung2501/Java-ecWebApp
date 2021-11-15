package com.ute.ecwebapp.beans;

public class Category {
    private  int CatID;
    private String CatName;

    public Category() {
    }

    public Category(int CatID, String CatName) {
        this.CatID = CatID;
        this.CatName = CatName;
    }

    public Category( String CatName) {
        this.CatID = -1;
        this.CatName = CatName;
    }
    public int getCatID() {
        return CatID;
    }

    public String getCatName() {
        return CatName;
    }
}

