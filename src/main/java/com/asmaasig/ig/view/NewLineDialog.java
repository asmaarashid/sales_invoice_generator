
package com.asmaasig.ig.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewLineDialog extends JDialog{
    // declaring the new line dialog components
    private JTextField newItemNameField;
    private JTextField newItemAmountField;
    private JTextField newItemPriceField;
    private JLabel itemNameLbl;
    private JLabel itemCountLbl;
    private JLabel itemPriceLbl;
    private JButton okBtn;
    private JButton cancelBtn;
    
    // adding the components to the dialog in the frame
    public NewLineDialog(Frame frame) {
        newItemNameField = new JTextField(20);
        itemNameLbl = new JLabel(" Item Name");
        newItemAmountField = new JTextField(20);
        itemCountLbl = new JLabel(" Item Count");
        newItemPriceField = new JTextField(20);
        itemPriceLbl = new JLabel(" Item Price");
        
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        // setting action command for the dialog buttons
        okBtn.setActionCommand("createNewLine");
        cancelBtn.setActionCommand("CancelCreateNewLine");
        
        // adding the controller as the action listener for the dialog
        okBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        
        // determining the layount "size" of the dialog
        setLayout(new GridLayout(4, 2));
        
        // completing adding the components
        add(itemNameLbl);
        add(newItemNameField);
        add(itemCountLbl);
        add(newItemAmountField);
        add(itemPriceLbl);
        add(newItemPriceField);
        add(okBtn);
        add(cancelBtn);
        pack();
    }
    
    // this is a text field to get the item's name from the user
    public JTextField getNewItemNameField() {
        return newItemNameField;
    }
    
    // this is a text field to get the item's amount from the user
    public JTextField getNewItemAmountField() {
        return newItemAmountField;
    }
    
    // this is a text field to get the item's price from the user
    public JTextField getNewItemPriceField() {
        return newItemPriceField;
    }
}
