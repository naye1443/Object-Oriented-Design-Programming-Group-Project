package NozamaGui.Screens;

import DataTypes.Item;
import Model.NozamaSystem;

import javax.swing.*;
import java.awt.*;

public class CustomerDashboard extends JFrame
{
    private JPanel CustomerDashboardPanel;
    private JList feed;
    private DefaultListModel feedModel;


    public CustomerDashboard()
    {
        setTitle("Customer Dashboard");
        setContentPane(CustomerDashboardPanel);
        setMinimumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        feedModel = new DefaultListModel<>();
        feed.setModel(feedModel);

        refreshFeed();

        NozamaSystem.getInstance().informView(CustomerDashboard.this); //same thing as setVisible(true); // must be last line

    }

    public void refreshFeed()
    {
        NozamaSystem instance = NozamaSystem.getInstance();

        feedModel.removeAllElements();
        for (Item item : instance.getInventory())
        {
            feedModel.addElement(item.toString());
        }
    }


}
