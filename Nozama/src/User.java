public class User
{
    public String userID, username, password, accountType;

    public User(String ID, String username, String password, String accountType)
    {
        this.userID = ID;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

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
