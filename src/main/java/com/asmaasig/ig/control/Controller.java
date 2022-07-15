
package com.asmaasig.ig.control;

import com.asmaasig.ig.model.Header;
import com.asmaasig.ig.model.HeaderTableModel;
import com.asmaasig.ig.model.Line;
import com.asmaasig.ig.model.LineTableModel;
import com.asmaasig.ig.view.Frame;
import com.asmaasig.ig.view.NewInvoiceDialog;
import com.asmaasig.ig.view.NewLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener{
    
    // creating objects of associated classes
    private Frame frame;
    private NewInvoiceDialog newInvoiceDialog;
    private NewLineDialog newLineDialog;
    
    // controller constructor with frame passed as argument
    public Controller(Frame frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String actionCommand = e.getActionCommand();
        // this is a check point for debugging purposes
        System.out.println("pleaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaase");

        // switch control to determine whitch action to perform
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
            case "CancelCreateNewInv":
                cancelCreateNewInv();
                break;
            case "createNewInvOk":
                approveCreateNewInv();
                break;
            case "CancelCreateNewLine":
                cancelCreateNewLine();
                break;
            case "createNewLine":
                approveCreateNewLine();
                break;
        }
    }
    
    // load file method
    private void loadFile() {
        //declaring file chooser
        JFileChooser fChooser = new JFileChooser();
        
        // wrong file format exception handling
        try{
            // choosing and uploading a file
            int result = fChooser.showOpenDialog(frame);
            // choosing the invoice file
            if(result == JFileChooser.APPROVE_OPTION){
                File headerFile = fChooser.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerList = Files.readAllLines(headerPath);
                
                //check point
                System.out.println("invoices have been read successfully");
                
                // printing the data from the file into the header table
                ArrayList<Header> invoiceArray = new ArrayList<>();
                for(String headerRow : headerList){
                    String[] headerRowCells = headerRow.split(",");
                    int invNum = Integer.parseInt(headerRowCells[0]);
                    String invDate = headerRowCells[1];
                    String customerName = headerRowCells[2];
                    Header invoice = new Header(invNum, invDate, customerName);
                    invoiceArray.add(invoice); 
                }
                
                // check point
                System.out.println("Check");
                
                // choosing the lines file
                result = fChooser.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION){
                    File lineFile = fChooser.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineList = Files.readAllLines(linePath);
                    
                    // check point
                    System.out.println("Items have been read successfully");
                    
                    // printing the data from the lines file into the table
                    for(String lineRow : lineList){
                        String[] lineRowCells = lineRow.split(",");
                        int invNum = Integer.parseInt(lineRowCells[0]);
                        String itemName = lineRowCells[1];
                        double itemPrice = Double.parseDouble(lineRowCells[2]);
                        int amount = Integer.parseInt(lineRowCells[3]);
                        
                        // getting the invoice number
                        Header inv = null;
                        for(Header invoice : invoiceArray){
                            if(invoice.getNum() == invNum){
                                inv = invoice;
                                break;
                            }
                        }
                        Line line = new Line(itemName, itemPrice, amount, inv);
                        inv.getLines().add(line);
                    }
                    
                    // check point
                    System.out.println("check point 2222222");
                }
               // tables dispalying 
               frame.setInvoices(invoiceArray);
               HeaderTableModel invoicesTableModel = new HeaderTableModel(invoiceArray);
               frame.setInvoicesTableModel(invoicesTableModel);
               frame.getInvoiceTable().setModel(invoicesTableModel);
               frame.getInvoicesTableModel().fireTableDataChanged();
            }
        }catch(IOException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Wrong Format, Cannot Read File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // save file method
    private void saveFile() {
        String invoices = "";
        String invoicesLines = "";
        ArrayList<Header> invoicesToSave = frame.getInvoices();
        for(Header invoice : invoicesToSave){
            String invoiceCSVformat = invoice.fitchInvAsCSVformat();
            invoices += invoiceCSVformat;
            invoices += "\n";
            for(Line invLines : invoice.getLines()){
                String lineCSVformat = invLines.fitchLineAsCSVformat();
                invoicesLines += lineCSVformat;
                invoicesLines += "\n";
            }
        }
        
        // check point
        System.out.println("Check point for save file");
        
        // Exception handling for wring format
        try{
            // displaying file chooser for save
            JFileChooser fileChooserForSave = new JFileChooser();
            int saveResult = fileChooserForSave.showSaveDialog(frame);
            // writing the data into a file in case of clicking on save
            if (saveResult == JFileChooser.APPROVE_OPTION){
            File updatedHeaderFile = fileChooserForSave.getSelectedFile();
            FileWriter headerFileWriter = new FileWriter(updatedHeaderFile);
            headerFileWriter.write(invoices);
            headerFileWriter.flush();
            headerFileWriter.close();
            
            // flushing and closing the save dialog in case of cancel
            saveResult = fileChooserForSave.showSaveDialog(frame);
            if(saveResult == JFileChooser.APPROVE_OPTION){
                File updatedLineFile = fileChooserForSave.getSelectedFile();
                FileWriter linesFileWriter = new FileWriter(updatedLineFile);
                linesFileWriter.write(invoicesLines);
                linesFileWriter.flush();
                linesFileWriter.close();
            }
        } 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(frame, "Wrong File Format", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    // creating new invoice method
    private void createInvoice() {
        // displaying a dialog for creating a new invoice
        newInvoiceDialog = new NewInvoiceDialog(frame);
        newInvoiceDialog.setVisible(true);
    }
    
    // delete invoice method
    private void deleteInvoice() {
        // determine whitch row of invoices is selected and delete it only
        int selectedInvForDelete = frame.getInvoiceTable().getSelectedRow();
        if(selectedInvForDelete != -1){
            frame.getInvoices().remove(selectedInvForDelete);
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }
    
    // add item method
    private void addItem() {
        // displaying a dialog for creating a new line into a selected invoice
        newLineDialog = new NewLineDialog(frame);
        newLineDialog.setVisible(true);
    }
    
    // delete item from invoice method
    private void deleteItem() {
        // determine whitch row of lines is selected and delete it only
        int selectedLineForDelete = frame.getLineTable().getSelectedRow();
        if(selectedLineForDelete != -1){
            LineTableModel updatedLineTableModel = (LineTableModel)frame.getLineTable().getModel();
            updatedLineTableModel.getInvRows().remove(selectedLineForDelete);
            updatedLineTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }
    
    // canceling create invoice dialog
    private void cancelCreateNewInv() {
        newInvoiceDialog.setVisible(false);
        newInvoiceDialog.dispose();
        newInvoiceDialog = null; 
    }
    
    // creating new invoice in pre uploaded file
    private void approveCreateNewInv() {
        
        // getting the data from the dialog
        int newInvNum = frame.whatsNextInvoiceIndex();
        String newInvDate = newInvoiceDialog.getNewInvoiceDateField().getText();
        String newCustomerName = newInvoiceDialog.getNewCustomerNameField().getText();
        
        //Wrong Date Exception Handling
        try{
            String[] dateFormatPortions = newInvDate.split("-");
            if(dateFormatPortions.length < 3){
                JOptionPane.showMessageDialog(frame, "Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                // splitting the date into portions for validation 
                int dayPortion = Integer.parseInt(dateFormatPortions[0]);
                int monthPortion = Integer.parseInt(dateFormatPortions[1]);
                int yearPortion = Integer.parseInt(dateFormatPortions[2]);
                String yearPortionString = Integer.toString(yearPortion);
                // date validation
                if(dayPortion > 31 || monthPortion > 12 || yearPortionString.length() != 4 ){
                    // wrong numeric date format validation
                    JOptionPane.showMessageDialog(frame, "Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
                // customer name format validation
                }else if(newCustomerName.matches(".*[0-9].*")){
                    JOptionPane.showMessageDialog(frame, "Customer Name Cannot Contain Numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    // displaying the new invoice into the table
                    Header newInv = new Header(newInvNum, newInvDate, newCustomerName);
                    frame.getInvoices().add(newInv);
                    frame.getInvoicesTableModel().fireTableDataChanged();
                    newInvoiceDialog.setVisible(false);
                    newInvoiceDialog.dispose();
                    newInvoiceDialog = null;
                } 
            }
        }catch(Exception ex){
            // wrong date format validation
            JOptionPane.showMessageDialog(frame, "Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    // flushing and closing new line dialog method
    private void cancelCreateNewLine() {
        newLineDialog.setVisible(false);
        newLineDialog.dispose();
        newLineDialog = null;
    }
    
    // adding new item to an invoice method
    private void approveCreateNewLine() {
        //Price and Count Data Type Handling
        try{
            // getting data from the dialog
            int selectedInv = frame.getInvoiceTable().getSelectedRow();
            String newItemName = newLineDialog.getNewItemNameField().getText();
            int newItemCount = Integer.parseInt(newLineDialog.getNewItemAmountField().getText());
            int newItemPrice = Integer.parseInt(newLineDialog.getNewItemPriceField().getText());
            // item price and amount validation
            if(selectedInv != -1){
                if(newItemCount < 1){
                    JOptionPane.showMessageDialog(frame, "Item Count Must Be At Least 1", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(newItemPrice < 0){
                    JOptionPane.showMessageDialog(frame, "Item Price Cannot Be In Minus", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    // displaying the new line created into the table
                    Header selectedInvoice = frame.getInvoices().get(selectedInv);
                    Line addNewLine = new Line(newItemName, newItemPrice, newItemCount, selectedInvoice);
                    selectedInvoice.getLines().add(addNewLine);            
                    LineTableModel newLineTableModel = (LineTableModel) frame.getLineTable().getModel();           
                    newLineTableModel.fireTableDataChanged();
                    frame.getInvoicesTableModel().fireTableDataChanged();
                    newLineDialog.setVisible(false);
                    newLineDialog.dispose();
                    newLineDialog = null;
                }
            }
    
        }catch(NumberFormatException ex){
                // price and acount errors handling
                JOptionPane.showMessageDialog(frame, "Price and Amount Must Be Numbers", "Error" ,JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvoiceIndex = frame.getInvoiceTable().getSelectedRow();
        if(selectedInvoiceIndex != -1){
            System.out.println("you've selected row: " + selectedInvoiceIndex);
            Header choosenInvoice = frame.getInvoices().get(selectedInvoiceIndex);  

            frame.getInvNumLabel().setText(""+choosenInvoice.getNum());
            frame.getInvDateLabel().setText(choosenInvoice.getDate());
            frame.getCustomerLabel().setText(choosenInvoice.getCustomer());
            frame.getInvTotalLabel().setText(""+choosenInvoice.getInvTotalPrice());

            LineTableModel lineTableModel = new LineTableModel(choosenInvoice.getLines());
            frame.getLineTable().setModel(lineTableModel);
            lineTableModel.fireTableDataChanged();
        }
    }
    
}
