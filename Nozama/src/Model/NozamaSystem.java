package Model;

import DataTypes.*;
import NozamaGui.View;
import ReadWrite.JsonHandler;

import ReadWrite.Json.JSONArray;
import ReadWrite.Json.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

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

    /**
     *
     * @param profitObj Jsonobject
     */
    private void parseProfitsObject(JSONObject profitObj)
    {
        String key = profitObj.keySet().toString();
        key = key.substring(1, key.length() - 1); // removes the [], results in: "000"

        JSONObject values = (JSONObject) profitObj.get(key);

        String sprofit, srevenues, scosts;
        sprofit = (String) values.get("profit");
        srevenues = (String) values.get("revenues");
        scosts = (String) values.get("costs");

        float profit, revenues, costs;
        profit = Float.parseFloat(sprofit);
        revenues = Float.parseFloat(srevenues);
        costs = Float.parseFloat(scosts);

        vendors.add(new SellerAccount(key, profit, revenues, costs));

    }

    /**
     * Loads Vendor Data From ProfitsObject and stores in JSONArray VendorData
     */
    private void loadVendorsFromJson()
    {
        vendors.clear();

        vendorData = jsonHandler.getJSONArrayFromJson("Nozama/testdata/profits.json");
        vendorData.forEach(vendor -> parseProfitsObject((JSONObject) vendor));
    }

    /**
     * Parses User JSONObject. appends new user to User ArrayList
     * @param user JSONObject that Represents user
     */
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

    /**
     * loads User JSONObject into UserData
     */
    private void loadUsersFromJson()
    {
        users.clear();

        userData = jsonHandler.getJSONArrayFromJson("Nozama/testdata/users.json");
        userData.forEach( user -> parseUserDataObject((JSONObject) user));
    }

    /**
     *
     * @param bundleItem JSON bundleItem
     * @param vendor Vendor in Bundeltem
     * @return parses "items.json" in bundles "b000, b001, ..." and returns a new Item object with below values.
     */
    private Item parseBundleItem(JSONObject bundleItem, String vendor)
    {
        String key = bundleItem.keySet().toString();
        key = key.substring(1, key.length() - 1);

        JSONObject values = (JSONObject) bundleItem.get(key);

        String name, invoicePrice,sellPrice, description, quantity;
        name = (String) values.get("name");
        invoicePrice = (String) values.get("invoice_price");
        sellPrice = (String) values.get("sell_price");
        description = (String) values.get("description");
        quantity = (String) values.get("quantity");

        return new Item(key, name, invoicePrice, sellPrice, description, quantity, vendor);

    }

    /**
     * Reads Key, If Key has char b, then Creates a bundle Item from bundles in "items.json" "b000, b001, ..."
     * and adds them to inventory ArrayList.
     * If Key is not b, then do the same but with an item.
     * @param item
     */
    private void parseInventoryDataObject(JSONObject item)
    {
        String key = item.keySet().toString(); // gets the key in the form: "[000]"
        key = key.substring(1, key.length() - 1); // removes the [], results in: "000"

        if (key.charAt(0) == 'b')
        {
            JSONObject values = (JSONObject) item.get(key);

            String bundleName, vendor, quantity;

            bundleName = (String) values.get("bundleName");
            vendor = (String) values.get("vendor");
            quantity = (String) values.get("quantity");

            Bundle bundle = new Bundle(bundleName, vendor, quantity);

            JSONArray bundledItems = (JSONArray) values.get("items");

            for (Object obj : bundledItems)
            {
                bundle.addItem(parseBundleItem((JSONObject) obj, vendor));
            }

            inventory.add(bundle);

        }
        else
        {
            JSONObject values = (JSONObject) item.get(key);

            String name, invoicePrice,sellPrice, description, quantity, vendor;
            name = (String) values.get("name");
            invoicePrice = (String) values.get("invoice_price");
            sellPrice = (String) values.get("sell_price");
            description = (String) values.get("description");
            quantity = (String) values.get("quantity");
            vendor = (String) values.get("vendor");


            inventory.add(new Item(key, name, invoicePrice, sellPrice, description, quantity, vendor));
        }


    }

    /**
     * loads inventory from "item.json", and decomposes inventory Data into an Item or Bundle using ParseInventory
     * DataObject
     */
    private void loadInventoryFromJson()
    {
        inventory.clear();

        inventoryData = jsonHandler.getJSONArrayFromJson("Nozama/testdata/items.json");
        inventoryData.forEach( item -> parseInventoryDataObject((JSONObject) item));
    }

    /**
     *
     * @param username
     * @param password
     * @return User within Json To get account Type
     */
    public User logIn(String username, String password)
    {
        loadUsersFromJson();
        loadVendorsFromJson();
        loadInventoryFromJson();
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

    public void updateProfitsJSON()
    {
        JSONArray output = new JSONArray();
        for (SellerAccount vendor : vendors)
        {
            output.add(vendor.toJSONObject());
        }
        jsonHandler.writeToJson("Nozama/testdata/profits.json", output);
    }

    /**
     *
     * @return Inventory Loaded from Json
     */
    public ArrayList<IItem> getInventory()
    {
        loadInventoryFromJson();
        return inventory;
    }

    /**
     *
     * @return Vendors that from Json
     */
    public ArrayList<SellerAccount> getVendors()
    {
        loadVendorsFromJson();
        return vendors;
    }

    /**
     *
     * @param username
     * @return vendor
     */
    public SellerAccount getSeller(String username)
    {
        loadVendorsFromJson();
        for (SellerAccount vendor : vendors)
        {
            if (vendor.getUserName().equals(username)){
                return vendor;
            }
        }
        return null;
    }

    /**
     * @return Getter that returns cart
     */
    public Cart getCart()
    {
        return cart;
    }

    /**
     * @param user Mutator sets currentUser to user
     */
    public void setCurrentUser(User user)
    {
        currentUser = user;
    }

    /**
     * @return Getter that returns currentUser
     */
    public User getCurrentUser()
    {
        return currentUser;
    }

    /**
     * @param screen Shows view which is screen is in foreground
     */
    public void informView(Window screen)
    {
        view.showScreen(screen);
    }

    private static NozamaSystem instance;
    private JsonHandler jsonHandler = new JsonHandler();

    private JSONArray userData;
    private JSONArray inventoryData;

    private JSONArray vendorData;

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<IItem> inventory = new ArrayList<>();

    private ArrayList<SellerAccount> vendors = new ArrayList<>();

    private View view = new View();

    private User currentUser = null;

    private Cart cart = new Cart();

}
