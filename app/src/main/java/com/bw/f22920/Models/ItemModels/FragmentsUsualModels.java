package com.bw.f22920.Models.ItemModels;

public class FragmentsUsualModels {
    private String itemName;
    private double price;
    private int quantity;
    public int picturedata;

    public FragmentsUsualModels(){

    }

    public FragmentsUsualModels(String itemName, double price, int quantity, int picturedata) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.picturedata = picturedata;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
