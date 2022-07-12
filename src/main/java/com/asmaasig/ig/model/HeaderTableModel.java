
package com.asmaasig.ig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class HeaderTableModel extends AbstractTableModel{
    
    
    private ArrayList<Header> invoices;
    private String[] headerTableColumnsNames = {"No." , "Date" , "Customer" , "Total"};

    public HeaderTableModel(ArrayList<Header> invoices) {
        this.invoices = invoices;
    }
    
    @Override
    public int getRowCount() {
        return invoices.size();
        
    }

    @Override
    public int getColumnCount() {
        return headerTableColumnsNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return headerTableColumnsNames[column]; 
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Header invoice = invoices.get(rowIndex);
        switch(columnIndex){
            case 0: return invoice.getNum();
            case 1: return invoice.getDate();
            case 2: return invoice.getCustomer();
            case 3: return invoice.getInvTotalPrice();
            default: return"";
        
        }
    }
}
