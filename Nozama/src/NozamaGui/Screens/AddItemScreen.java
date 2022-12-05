package NozamaGui.Screens;

import DataTypes.SellerAccount;
import Model.NozamaSystem;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AddItemScreen extends JDialog
{
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField invoicePriceTextField;
    private JTextField sellPriceTextField;
    private JTextField descriptionTextField;
    private JSpinner quantitySpinner;
    private JTextField vendorTextField;
    private JButton addItemButton;

    public AddItemScreen(SellerAccount account, SellerDashboard accountDashboard)
    {
        setTitle("Add Item");
        setContentPane(mainPanel);
        setMinimumSize(new Dimension(500, 429));
        setSize(500, 700);

        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Exit without saving?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    accountDashboard.setIsEditing(false);
                    dispose();
                }
            }

        };
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(exitListener);


        NozamaSystem instance = NozamaSystem.getInstance();

        vendorTextField.setText(account.getUserName());
        quantitySpinner.setValue(1);

        quantitySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) quantitySpinner.getValue() < 1)
                    quantitySpinner.setValue(1);
            }
        });

        instance.informView(AddItemScreen.this); //same thing as setVisible(true); // must be last line


    }


}
