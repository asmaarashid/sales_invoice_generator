
package com.asmaasig.ig.model;

public class Line {
    
    
    private int num;
    private String itemName;
    private double itemPrice;
    private int amount;
    private Header header;
    public Line() {
    }

    public Line(int num, String item, double price, int amount) {
        this.num = num;
        this.itemName = item;
        this.itemPrice = price;
        this.amount = amount;
    }

    public Line(int num, String item, double price, int amount, Header header) {
        this.num = num;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    @Override
    public String toString() {
        return "Line{" + "num=" + num + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", amount=" + amount + '}';
    }

    
    
    
}
