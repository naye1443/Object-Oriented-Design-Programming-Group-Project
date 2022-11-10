package NozamaGui.Screens;

import DataTypes.IAccount;
import DataTypes.User;
import Model.NozamaSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JDialog
{
    private JTextField tfUsername;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPasswordField pfPassword;

    public LoginScreen(JFrame parent)
    {
        super(parent); //This line must always be first statement in constructor
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        NozamaSystem instance = NozamaSystem.getInstance();


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput = tfUsername.getText();
                String passwordInput = String.valueOf(pfPassword.getPassword());

                System.out.println(usernameInput);
                System.out.println(passwordInput);



                User user = instance.logIn(usernameInput, passwordInput);

                if (user != null)
                {
                    IAccount account = user.getAccount();
                    account.OnLogIn();
                }
                else
                {
                    showErrorMessage(LoginScreen.this);
                }

            }
        });


        setVisible(true); // This line must be after the action listeners
    }

    private void showErrorMessage(LoginScreen loginScreen)
    {
        JOptionPane.showMessageDialog(loginScreen,
                "Username or password invalid",
                "try again", JOptionPane.ERROR_MESSAGE);
    }


    public static void main(String[] args) {
        LoginScreen loginScreen = new LoginScreen(null);
    }

}
