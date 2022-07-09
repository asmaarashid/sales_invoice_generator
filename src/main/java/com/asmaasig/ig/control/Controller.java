
package com.asmaasig.ig.control;

import com.asmaasig.ig.model.Header;
import com.asmaasig.ig.model.Line;
import com.asmaasig.ig.view.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

public class Controller implements ActionListener{
    
    private Frame frame;
    public Controller(Frame frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String actionCommand = e.getActionCommand();
        System.out.println("pleaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaase");
        
        
        switch (actionCommand){
        
            case "Load File" :
                loadFile();
                break;
            case "Save File" :
                saveFile();
                break;
            case "Create Invoice" :
                createInvoice();
                break;
            case "Delete Invoice" :
                deleteInvoice();
                break;
            case "Add New Item" :
                addItem();
                break;
            case "Delete Item" :
                deleteItem();
                break;
        }
    }

    private void loadFile() {
        JFileChooser fChooser = new JFileChooser();
        try{
            int result = fChooser.showOpenDialog(frame);
            if(result == JFileChooser.APPROVE_OPTION){
                File headerFile = fChooser.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerList = Files.readAllLines(headerPath);
                
                System.out.println("invoices have been read successfully");
                
                ArrayList<Header> invoiceArray = new ArrayList<>();
                for(String headerRow : headerList){
                    
                    String[] headerRowCells = headerRow.split(",");
                    int invNum = Integer.parseInt(headerRowCells[0]);
                    String invDate = headerRowCells[1];
                    String customerName = headerRowCells[2];
                    
                    Header invoice = new Header(invNum, invDate, customerName);
                    
                    invoiceArray.add(invoice);
                    
                }
                System.out.println("Check");
                
                result = fChooser.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    File lineFile = fChooser.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineList = Files.readAllLines(linePath);
                    System.out.println("Items have been read successfully");
                    
                    for(String lineRow : lineList){
                    
                        String[] lineRowCells = lineRow.split(",");
                        int invNum = Integer.parseInt(lineRowCells[0]);
                        String itemName = lineRowCells[1];
                        double itemPrice = Double.parseDouble(lineRowCells[2]);
                        int amount = Integer.parseInt(lineRowCells[3]);

                        Header inv = null;
                        for(Header invoice : invoiceArray){
                            if(invoice.getNum() == invNum){
                                inv = invoice;
                                break;
                            }
                        }
                        Line line = new Line(invNum, itemName, itemPrice, amount, inv);
                        inv.getLines().add(line);
                    }
                    System.out.println("check point 2222222");
                }
                
               frame.setInvoices(invoiceArray);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }

    private void saveFile() {
    }

    private void createInvoice() {
    }

    private void deleteInvoice() {
    }

    private void addItem() {
    }

    private void deleteItem() {
    }
    
}
