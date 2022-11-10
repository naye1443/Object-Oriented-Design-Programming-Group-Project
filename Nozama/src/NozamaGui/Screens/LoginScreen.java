package NozamaGui.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JDialog
{
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPasswordField pfPassword;

    public LoginScreen(JFrame parent)
    {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput = tfUsername.getText();
                String passwordInput = String.valueOf(pfPassword.getPassword());

                System.out.println(usernameInput);
                System.out.println(passwordInput);
            }
        });


        setVisible(true); // This line must be after the action listeners
    }

    public static void main(String[] args) {
        LoginScreen loginScreen = new LoginScreen(null);
    }

}
