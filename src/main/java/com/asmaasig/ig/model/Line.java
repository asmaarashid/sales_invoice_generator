
package com.asmaasig.ig.model;

public class Line {
    
    
    private String itemName;
    private double itemPrice;
    private int amount;
    private Header header;
    
    
    
    public Line() {
    }

    public Line(String item, double price, int amount) {
        this.itemName = item;
        this.itemPrice = price;
        this.amount = amount;
    }

    public Line(String item, double price, int amount, Header header) {
        this.itemName = item;
        this.itemPrice = price;
        this.amount = amount;
        this.header = header;
    }
    
    public double getLineTotalPrice(){
        return itemPrice * amount;
    }
    
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getItem() {
        return itemName;
    }

    public void setItem(String item) {
        this.itemName = item;
    }

    public double getPrice() {
        return itemPrice;
    }

    public void setPrice(double price) {
        this.itemPrice = price;
    }

    public Header getHeader() {
        return header;
    }
    
    @Override
    public String toString() {
        return "Line{" + "num=" + header.getNum() + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", amount=" + amount + '}';
    }

    
    
    
}
