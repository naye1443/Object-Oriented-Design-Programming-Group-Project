package DataTypes;

import DataTypes.User;
import Model.Cart;
import Model.NozamaSystem;

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

//    private User userinstance;
////    CustomerAccount(){
////        NozamaSystem instance = NozamaSystem.getInstance();
////        userinstance = instance.logIn("username", "password");
////
////        //if customer
////            // initalize a cart
////        // if seller
////            // initalize inventory
//
//    }

    // Creates a customer and Seller Homepage instance depending on Account type.
    @Override
    public void OnLogIn()
    {
        System.out.println("A customer has logged in");
    }

    // add to cart


    // get inventory




}
