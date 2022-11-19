package Model;

import DataTypes.Item;
import DataTypes.User;
import NozamaGui.View;
import ReadWrite.JsonHandler;

import ReadWrite.Json.JSONArray;
import ReadWrite.Json.JSONObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class manages all the data of the program.
 * This class implements the Singleton Pattern
 * @author Jordan Diaz
 * */
public class NozamaSystem
{
    /**
     * Private constructor
     * @author Jordan Diaz
     * */
    private NozamaSystem(){}

    /**
     * This method gets the current instance of this class
     *
     * */
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


    public User logIn(String username, String password)
    {
        loadUsersFromJson();
        for (User user : users)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }

        return null;
    }

    /**
     * This Method updates the users.json file to accurately represent the users ArrayList
     * @author Jordan Diaz
     */
    public void updateUserJSON()
    {
        JSONArray output = new JSONArray();
        for (User user : users)
        {
            output.add(user.toJSONObject());
        }
        jsonHandler.writeToJson("Nozama/testdata/users.json", output);
    }

    public ArrayList<Item> getInventory()
    {
        loadInventoryFromJson();
        return inventory;
    }

    public void setCurrentUser(User user)
    {
        currentUser = user;
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void informView(Window screen)
    {
        view.showScreen(screen);
    }

    private static NozamaSystem instance;
    private JsonHandler jsonHandler = new JsonHandler();

    private JSONArray userData;
    private JSONArray inventoryData;

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Item> inventory = new ArrayList<>();

    private View view = new View();

    private User currentUser = null;

}
