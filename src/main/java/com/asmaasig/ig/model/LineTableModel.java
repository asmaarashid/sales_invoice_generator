
package com.asmaasig.ig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class LineTableModel extends AbstractTableModel{
    
    private ArrayList<Line> invRows;
    
    private String[] lineTableColumnsNames = {"No." , "Item Name" , "Item Price" , "Count" , "Item Total"};

    public LineTableModel(ArrayList<Line> invRows) {
        this.invRows = invRows;
    }
    
    @Override
    public int getRowCount() {
        return invRows.size();
    }

    @Override
    public int getColumnCount() {
        return lineTableColumnsNames.length;
    }

    @Override
    public String getColumnName(int lineColumn) {
        return lineTableColumnsNames[lineColumn];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Line line = invRows.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return line.getHeader().getNum();
            case 1 : return line.getItem();
            case 2 : return line.getPrice();
            case 3 : return line.getAmount();
            case 4 : return line.getLineTotalPrice();
            default : return "";
        
        }
     }

    public ArrayList<Line> getInvRows() {
        return invRows;
    }   
}
