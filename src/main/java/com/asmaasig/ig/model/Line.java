
package com.asmaasig.ig.model;

public class Line {
    
    // lines table variables declaration
    private String itemName;
    private double itemPrice;
    private int amount;
    private Header header;
    
    // no argument constructor
    public Line() {
    }
    
    // constructors with all variables passed
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
    
    // get header class
    public Header getHeader() {
        return header;
    }
    
    // item name getter and setter
    public String getItem() {
        return itemName;
    }

    public void setItem(String item) {
        this.itemName = item;
    }
    
    // item price getter and setter
    public double getPrice() {
        return itemPrice;
    }

    public void setPrice(double price) {
        this.itemPrice = price;
    }
    
    // item amount getter and setter
    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    // getting total price of item depending on the amount
    public double getLineTotalPrice(){
        return itemPrice * amount;
    }
   
    // converting the lines list into comma separated value format
    public String fitchLineAsCSVformat(){
        return header.getNum() + "," + itemName + "," + itemPrice + "," + amount;
    }
    
    @Override
    public String toString() {
        return "Line{" + "num=" + header.getNum() + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", amount=" + amount + '}';
    }

    
    
    
}
