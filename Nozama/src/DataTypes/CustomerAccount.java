package DataTypes;

import DataTypes.User;
import Model.NozamaSystem;
import NozamaGui.Screens.CustomerDashboard;

/**
 * @author Jordan Diaz
 * CustomerAccount instantiates customerDashboard
 */
public class CustomerAccount implements IAccount
{
    User accountUser;

    /**
     * CustomerAccount Constructor takes in an instant of the User object and defines the accountUser variable.
     */
    public CustomerAccount(User user)
    {
        this.accountUser = user;
    }


    /**
     * Creates a customer and Seller Homepage instance depending on Account type.
     */
    @Override
    public void OnLogIn()
    {
        System.out.println("A customer has logged in");
        CustomerDashboard customerDashboard = new CustomerDashboard();
    }

    // add to cart

    // get inventory




}
