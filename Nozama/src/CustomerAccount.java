public class CustomerAccount implements IAccount
{
    private User userinstance;
    CustomerAccount(){
        NozamaSystem instance = NozamaSystem.getInstance();
        userinstance = instance.logIn("username", "password");

        //if customer
            // initalize a cart
        // if seller
            // initalize inventory

    }

    // Creates a customer and Seller Homepage instance depending on Account type.
    @Override
    public void OnLogIn()
    {

    }

    // add to cart

    // get inventory




}
