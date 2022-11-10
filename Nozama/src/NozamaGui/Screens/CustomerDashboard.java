package NozamaGui.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame
{
    private JButton button1;
    private JPanel CustomerDashboardPanel;

    public CustomerDashboard(JFrame parent)
    {
        setTitle("Customer Dashboard");
        setContentPane(CustomerDashboardPanel);
        setMinimumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
