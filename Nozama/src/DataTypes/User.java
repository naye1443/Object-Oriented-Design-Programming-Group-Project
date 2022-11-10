package DataTypes;


import ReadWrite.Json.JSONObject;

public class User
{
    private String userID, username, password, accountType;
    private IAccount account;

    /**
     * Constructor
     * @author Jordan Diaz
     * */
    public User(String ID, String username, String password, String accountType)
    {
        this.userID = ID;
        this.username = username;
        this.password = password;
        this.accountType = accountType;

        if (accountType.equals("customer"))
        {
            account = new CustomerAccount(this);
        }
        else if (accountType.equals("seller"))
        {
            account = new SellerAccount(this);
        }
    }

    /**
     * This Method redefines the variables of a specific DataTypes.User object
     * @author Jordan Diaz
     * */
    public void reconstruct(String ID, String username, String password, String accountType)
    {
        this.userID = ID;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    /**
     * This Method converts the variables of a specific DataTypes.User object into a JSONObject
     * @return JSONObject representation of DataTypes.User object
     * @author Jordan Diaz
     * */
    public JSONObject toJSONObject()
    {
        JSONObject data = new JSONObject();
        data.put("username", this.username);
        data.put("password", this.password);
        data.put("accountType", this.accountType);

        JSONObject header = new JSONObject();
        header.put(this.userID, data);

        return header;
    }

    /**
     * This Method converts the variables of a specific DataTypes.User object into a String
     * @return String representation of DataTypes.User object
     * @author Jordan Diaz
     * */
    @Override
    public String toString() {
        return "DataTypes.User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public IAccount getAccount()
    {
        return account;
    }
}
