package DataTypes;

public class SellerAccount implements IAccount{


    public User accountUser;
    /**
     * Constructor
     * @author Jordan Diaz
     */
    public SellerAccount(User user)
    {
        this.accountUser = user;
    }

    @Override
    public void OnLogIn()
    {
        System.out.println("A seller has logged in");
    }


}
