
package com.asmaasig.ig.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewInvoiceDialog extends JDialog {
    // declaring the new invoice dialog components
    private JTextField newCustomerNameField;
    private JTextField newInvoiceDateField;
    private JLabel customerNameLabel;
    private JLabel invoiceDateLable;
    private JButton okCreateInvButton;
    private JButton cancelNewInvButton;
    
    // adding the components to the dialog in the frame
    public NewInvoiceDialog(Frame frame) {
        customerNameLabel = new JLabel(" Customer Name:");
        newCustomerNameField = new JTextField(20);
        invoiceDateLable = new JLabel(" Invoice Date:");
        newInvoiceDateField = new JTextField(20);
        
        okCreateInvButton = new JButton("OK");
        cancelNewInvButton = new JButton("Cancel");
        
        // setting action command for the dialog buttons
        okCreateInvButton.setActionCommand("createNewInvOk");
        cancelNewInvButton.setActionCommand("CancelCreateNewInv");
        
        // adding the controller as the action listener for the dialog
        okCreateInvButton.addActionListener(frame.getController());
        cancelNewInvButton.addActionListener(frame.getController());
        
        // determining the layount "size" of the dialog
        setLayout(new GridLayout(3, 2));
        
        // completing adding the components
        add(invoiceDateLable);
        add(newInvoiceDateField);
        add(customerNameLabel);
        add(newCustomerNameField);
        add(okCreateInvButton);
        add(cancelNewInvButton);
        pack(); 
    }

    // this is a text field to get the invoice's date from the user
    public JTextField getNewInvoiceDateField() {
        return newInvoiceDateField;
    }
    
    // this is a text field to get the customer name firm the user
    public JTextField getNewCustomerNameField() {
        return newCustomerNameField;
    }
    
}
