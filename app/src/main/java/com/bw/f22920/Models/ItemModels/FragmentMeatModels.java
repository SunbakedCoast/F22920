package com.bw.f22920.Models.ItemModels;

public class FragmentMeatModels {
    private String itemName;
    private double price;
    private int quantity;
    public int picturedata;


    public FragmentMeatModels(){

    }

    public FragmentMeatModels(String itemName, double price, int quantity, int picturedata) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.picturedata = picturedata;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
