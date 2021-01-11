package com.bw.f22920.Models.CartModel;

public class CartArrayModelHometwo {
    public String itemname;
    public String quantity;
    public String price;

    public CartArrayModelHometwo(String itemname, String quantity, String price) {
        this.itemname = itemname;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
