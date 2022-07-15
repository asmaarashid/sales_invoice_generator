
package com.asmaasig.ig.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class NewInvoiceDialog extends JDialog {
    private JTextField newCustomerNameField;
    private JTextField newInvoiceDateField;
    private JLabel customerNameLabel;
    private JLabel invoiceDateLable;
    private JButton okCreateInvButton;
    private JButton cancelNewInvButton;

    public NewInvoiceDialog(Frame frame) {
        customerNameLabel = new JLabel("Customer Name:");
        newCustomerNameField = new JTextField(20);
        invoiceDateLable = new JLabel("Invoice Date:");
        newInvoiceDateField = new JTextField(20);
        okCreateInvButton = new JButton("OK");
        cancelNewInvButton = new JButton("Cancel");
        
        okCreateInvButton.setActionCommand("createNewInvOk");
        cancelNewInvButton.setActionCommand("CancelCreateNewInv");
        
        okCreateInvButton.addActionListener(frame.getController());
        cancelNewInvButton.addActionListener(frame.getController());
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDateLable);
        add(newInvoiceDateField);
        add(customerNameLabel);
        add(newCustomerNameField);
        add(okCreateInvButton);
        add(cancelNewInvButton);
        
        pack();
        
    }

    public JTextField getNewCustomerNameField() {
        return newCustomerNameField;
    }

    public JTextField getNewInvoiceDateField() {
        return newInvoiceDateField;
    }
    
}
