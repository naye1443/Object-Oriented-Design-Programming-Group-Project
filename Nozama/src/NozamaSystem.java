import ReadWrite.JsonHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class NozamaSystem
{
    private NozamaSystem(){}

    public static NozamaSystem getInstance()
    {
        if (instance == null)
        {
            instance = new NozamaSystem();
        }

        return instance;
    }

    private void parseUserDataObject(JSONObject user)
    {
        String key = user.keySet().toString(); // gets the key in the form: "[000]"
        key = key.substring(1, key.length() - 1); // removes the [], results in: "000"

        JSONObject values = (JSONObject) user.get(key);

        String username, password, accountType;
        username = (String) values.get("username");
        password = (String) values.get("password");
        accountType = (String) values.get("accountType");

        users.add(new User(key, username, password, accountType));

    }

    private void loadUsersFromJson()
    {
        users.clear();

        userData = jsonHandler.getJSONArrayFromJson("Nozama/testdata/users.json");
        userData.forEach( user -> parseUserDataObject((JSONObject) user));
    }

    private void parseInventoryDataObject(JSONObject item)
    {
        String key = item.keySet().toString(); // gets the key in the form: "[000]"
        key = key.substring(1, key.length() - 1); // removes the [], results in: "000"

        JSONObject values = (JSONObject) item.get(key);

        String name, price, description;
        name = (String) values.get("name");
        price = (String) values.get("price");
        description = (String) values.get("description");

        inventory.add(new Item(key, name, price, description));
    }

    private void loadInventoryFromJson()
    {
        inventory.clear();

        inventoryData = jsonHandler.getJSONArrayFromJson("Nozama/testdata/items.json");
        inventoryData.forEach( item -> parseInventoryDataObject((JSONObject) item));
    }


    public void printUserData()
    {
        loadUsersFromJson();
        for (User user : users)
        {
            System.out.println(user);
        }
    }

    public String getUserUsername(String key)
    {
        loadUsersFromJson();
        for (User user : users)
        {
            if (user.userID.equals(key))
            {
                return user.username;
            }
        }
        return null;
    }

    public String getUserPassword(String key)
    {
        loadUsersFromJson();
        for (User user : users)
        {
            if (user.userID.equals(key))
            {
                return user.password;
            }
        }
        return null;
    }

    public String getUserAccountType(String key)
    {
        loadUsersFromJson();
        for (User user : users)
        {
            if (user.userID.equals(key))
            {
                return user.accountType;
            }
        }
        return null;
    }

    public User logIn(String username, String password)
    {
        loadUsersFromJson();
        for (User user : users)
        {
            if (user.username.equals(username) && user.password.equals(password))
                return user;
        }

        return null;
    }

    public ArrayList<Item> getInventory()
    {
        loadInventoryFromJson();
        return inventory;
    }


    private static NozamaSystem instance;
    private JsonHandler jsonHandler = new JsonHandler();

    private JSONArray userData;
    private JSONArray inventoryData;

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Item> inventory = new ArrayList<>();

}
