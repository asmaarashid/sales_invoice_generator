
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
    
    private Frame frame;
    private NewInvoiceDialog newInvoiceDialog;
    private NewLineDialog newLineDialog;
    
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
                        Line line = new Line(itemName, itemPrice, amount, inv);
                        inv.getLines().add(line);

                    }
                    System.out.println("check point 2222222");
                }
                
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
        System.out.println("Check point for save file");
        try{
            JFileChooser fileChooserForSave = new JFileChooser();
        int saveResult = fileChooserForSave.showSaveDialog(frame);
        if (saveResult == JFileChooser.APPROVE_OPTION){
            File updatedHeaderFile = fileChooserForSave.getSelectedFile();
            FileWriter headerFileWriter = new FileWriter(updatedHeaderFile);
            headerFileWriter.write(invoices);
            headerFileWriter.flush();
            headerFileWriter.close();
            
            
            
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

    private void createInvoice() {
        newInvoiceDialog = new NewInvoiceDialog(frame);
        newInvoiceDialog.setVisible(true);
    }

    private void deleteInvoice() {
        int selectedInvForDelete = frame.getInvoiceTable().getSelectedRow();
        if(selectedInvForDelete != -1){
            frame.getInvoices().remove(selectedInvForDelete);
            frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    private void addItem() {
        newLineDialog = new NewLineDialog(frame);
        newLineDialog.setVisible(true);
    }

    private void deleteItem() {
        //int selectedInvForRowDelete = frame.getInvoiceTable().getSelectedRow();
        int selectedLineForDelete = frame.getLineTable().getSelectedRow();
        /*if(selectedInvForRowDelete != -1 &&  selectedLineForDelete != -1){
            Header invoiceToDeleteRow = frame.getInvoices().get(selectedInvForRowDelete);
            invoiceToDeleteRow.getLines().remove(selectedLineForDelete);
            LineTableModel updatedLineTableModel = new LineTableModel(invoiceToDeleteRow.getLines());
            frame.getLineTable().setModel(updatedLineTableModel);
            updatedLineTableModel.fireTableDataChanged();
        }*/
        if(selectedLineForDelete != -1){
            LineTableModel updatedLineTableModel = (LineTableModel)frame.getLineTable().getModel();
            updatedLineTableModel.getInvRows().remove(selectedLineForDelete);
            updatedLineTableModel.fireTableDataChanged();
            frame.getInvoicesTableModel().fireTableDataChanged();
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

    private void cancelCreateNewInv() {
        newInvoiceDialog.setVisible(false);
        newInvoiceDialog.dispose();
        newInvoiceDialog = null; 
    }

    private void approveCreateNewInv() {
        int newInvNum = frame.whatsNextInvoiceIndex();
        String newInvDate = newInvoiceDialog.getNewInvoiceDateField().getText();
        String newCustomerName = newInvoiceDialog.getNewCustomerNameField().getText();
        
        //Wrong Date Exception Handling
        try{
            String[] dateFormatPortions = newInvDate.split("-");
            if(dateFormatPortions.length < 3){
                JOptionPane.showMessageDialog(frame, "Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                
                int dayPortion = Integer.parseInt(dateFormatPortions[0]);
                int monthPortion = Integer.parseInt(dateFormatPortions[1]);
                int yearPortion = Integer.parseInt(dateFormatPortions[2]);
                String yearPortionString = Integer.toString(yearPortion);
                if(dayPortion > 31 || monthPortion > 12 || yearPortionString.length() != 4 ){
                    JOptionPane.showMessageDialog(frame, "Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    Header newInv = new Header(newInvNum, newInvDate, newCustomerName);
                    frame.getInvoices().add(newInv);
                    frame.getInvoicesTableModel().fireTableDataChanged();
                    newInvoiceDialog.setVisible(false);
                    newInvoiceDialog.dispose();
                    newInvoiceDialog = null;
                }
                
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(frame, "Wrong Date Format", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    

    private void cancelCreateNewLine() {
        newLineDialog.setVisible(false);
        newLineDialog.dispose();
        newLineDialog = null;
    }

    private void approveCreateNewLine() {
        //Price and Count Data Type Handling
        try{
            int selectedInv = frame.getInvoiceTable().getSelectedRow();
            String newItemName = newLineDialog.getNewItemNameField().getText();
            int newItemCount = Integer.parseInt(newLineDialog.getNewItemAmountField().getText());
            int newItemPrice = Integer.parseInt(newLineDialog.getNewItemPriceField().getText());

            if(selectedInv != -1){

                    Header selectedInvoice = frame.getInvoices().get(selectedInv);
                    Line addNewLine = new Line(newItemName, newItemPrice, newItemCount, selectedInvoice);
                    selectedInvoice.getLines().add(addNewLine);            
                    LineTableModel newLineTableModel = (LineTableModel) frame.getLineTable().getModel();           
                    newLineTableModel.fireTableDataChanged();
                    frame.getInvoicesTableModel().fireTableDataChanged();
                }

            

            newLineDialog.setVisible(false);
            newLineDialog.dispose();
            newLineDialog = null;
        }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Price and Amount Must Be Numbers", "Error" ,JOptionPane.ERROR_MESSAGE);
        }  
    }
    
}
