
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
public class NewLineDialog extends JDialog{
    private JTextField newItemNameField;
    private JTextField newItemAmountField;
    private JTextField newItemPriceField;
    private JLabel itemNameLbl;
    private JLabel itemCountLbl;
    private JLabel itemPriceLbl;
    private JButton okBtn;
    private JButton cancelBtn;
    
    public NewLineDialog(Frame frame) {
        newItemNameField = new JTextField(20);
        itemNameLbl = new JLabel("Item Name");
        
        newItemAmountField = new JTextField(20);
        itemCountLbl = new JLabel("Item Count");
        
        newItemPriceField = new JTextField(20);
        itemPriceLbl = new JLabel("Item Price");
        
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        okBtn.setActionCommand("createNewLine");
        cancelBtn.setActionCommand("CancelCreateNewLine");
        
        okBtn.addActionListener(frame.getController());
        cancelBtn.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 2));
        
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

    public JTextField getNewItemNameField() {
        return newItemNameField;
    }

    public JTextField getNewItemAmountField() {
        return newItemAmountField;
    }

    public JTextField getNewItemPriceField() {
        return newItemPriceField;
    }
}
