package NozamaGui.Screens;

import DataTypes.Item;
import Model.NozamaSystem;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class CustomerDashboard extends JFrame
{
    private JPanel CustomerDashboardPanel;
    private JList feed;
    private JTextArea itemDescriptionTextArea;
    private JButton addToCartButton;
    private JButton cartButton;
    private JSpinner quantitySpinner;
    private DefaultListModel feedModel;

    private Item currentItem;


    public CustomerDashboard()
    {
        //nozamaTextPane.setText("NOZAMA\n\nWelcome: " + NozamaSystem.getInstance().getCurrentUser().getUsername());

        setTitle("Customer Dashboard");
        setContentPane(CustomerDashboardPanel);
        setMinimumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        NozamaSystem instance = NozamaSystem.getInstance();

        feedModel = new DefaultListModel<>();
        feed.setModel(feedModel);

        refreshFeed();

        quantitySpinner.setValue(1);
        feed.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {


                if (!e.getValueIsAdjusting())
                {
                    currentItem = instance.getInventory().get(feed.getSelectedIndex());
                    itemDescriptionTextArea.setText(String.valueOf(currentItem));
                    quantitySpinner.setValue(1);
                }

            }
        });

        quantitySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                if (currentItem == null)
                {
                    quantitySpinner.setValue(1);
                    return;
                }

                int quantity = Integer.parseInt(currentItem.getQuantity());

                if ((int) quantitySpinner.getValue() > quantity)
                {
                    quantitySpinner.setValue(quantity);
                }
                else if ((int) quantitySpinner.getValue() < 1)
                {
                    quantitySpinner.setValue(1);
                }



            }
        });

        NozamaSystem.getInstance().informView(CustomerDashboard.this); //same thing as setVisible(true); // must be last line

    }

    public void refreshFeed()
    {
        NozamaSystem instance = NozamaSystem.getInstance();

        feedModel.removeAllElements();
        for (Item item : instance.getInventory())
        {
            feedModel.addElement(item.getName());
        }
    }


}
