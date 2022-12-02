package DataTypes;

import DataTypes.User;
import Model.Cart;
import Model.NozamaSystem;
import NozamaGui.Screens.CustomerDashboard;

public class CustomerAccount implements IAccount
{
    User accountUser;
    private Cart currCart;

    /**
     * Constructor
     * @author Jordan Diaz
     */
    public CustomerAccount(User user)
    {
        this.accountUser = user;
        this.currCart = new Cart();
    }


    // Creates a customer and Seller Homepage instance depending on Account type.
    @Override
    public void OnLogIn()
    {
        System.out.println("A customer has logged in");
        CustomerDashboard customerDashboard = new CustomerDashboard();
    }

    // add to cart


    // get inventory




}
