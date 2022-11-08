import org.json.simple.JSONObject;

public class User
{
    protected String userID, username, password, accountType;

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
    }

    /**
     * This Method redefines the variables of a specific User object
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
     * This Method converts the variables of a specific User object into a JSONObject
     * @return JSONObject representation of User object
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
     * This Method converts the variables of a specific User object into a String
     * @return String representation of User object
     * @author Jordan Diaz
     * */
    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
