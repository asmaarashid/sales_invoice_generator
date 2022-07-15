
package com.asmaasig.ig.model;

import java.util.ArrayList;

public class Header {
    
    // invoices table variables declaration
    private int num;
    private String date;
    private String customer;
    private ArrayList<Line> lines;
    
    // no argument constructor
    public Header() {
    }
    
    // constructor with all variables as arguments
    public Header(int num, String date, String customer) {
        this.num = num;
        this.date = date;
        this.customer = customer;
    }
    
    // customer name getter and setter
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    
    // invoice number getter and setter
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    
    // invoice date getter and setter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    // create arraylist of line for each invoice
    public ArrayList<Line> getLines() {
        if(lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }
    
    // get the total price of an invoice from all lines
    public double getInvTotalPrice(){
        double total = 0.0;
        for(Line line : getLines()){
            total += line.getLineTotalPrice();
        }
        return total;
    }
    
    // converting the invoices list into comma separated value format
    public String fitchInvAsCSVformat(){
        return num + "," + date + "," + customer;
    }
    
    @Override
    public String toString() {
        return "Header{" + "num=" + num + ", date=" + date + ", customer=" + customer + '}';
    }
 
}
