package DataTypes;

import Model.NozamaSystem;
import NozamaGui.Screens.CustomerDashboard;
import NozamaGui.Screens.SellerDashboard;
import ReadWrite.Json.JSONObject;

import java.util.Objects;

/**
 * SellerAccount class describes the behavior of the seller
 * @author Jordan Diaz
 */
public class SellerAccount implements IAccount{


    /**
     * Constructor defines the sellers account properties
     * @param username - name
     * @param profit - earnings
     * @param revenues - summations of all sold items
     * @param costs -  summations of invoice prices for all items
     */
    public SellerAccount(String username, float profit, float revenues, float costs)
    {

        this.userName = username;
        this.profit = profit;
        this.revenues = revenues;
        this.costs = costs;
    }

    /**
     * Creates seller dashboard instant
     */
    @Override
    public void OnLogIn()
    {
        System.out.println("A seller has logged in");
        SellerDashboard sellerDashboard = new SellerDashboard(this);
    }

    /**
     * Converts sellers profit, revenues, and costs variables to a JSON object.
     * @return JSONObject
     */
    public JSONObject toJSONObject()
    {
        JSONObject data = new JSONObject();
        data.put("profit", this.profit);
        data.put("revenues", this.revenues);
        data.put("costs", this.costs);

        JSONObject header = new JSONObject();
        header.put(this.userName, data);

        return header;
    }

    /**
     * Gets seller's userName property
     * @return string
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Overrides default toString method, to create custom toString output string.
     * @return string
     */
    @Override
    public String toString() {
        return "SellerAccount{" +
                "userName='" + userName + '\'' +
                ", profit=" + profit +
                ", revenues=" + revenues +
                ", costs=" + costs +
                '}';
    }

    public float getProfit() {
        return profit;
    }

    /**
     * Gets seller's revenues property
     * @return float
     */
    public float getRevenues() {
        return revenues;
    }

    /**
     * Gets seller's cost property
     * @return float
     */
    public float getCosts() {
        return costs;
    }

    /**
     * Object override comparison method, object that calls this method is testing if the same as object that's passed as argument.
     * @param o - Object passed by argument
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SellerAccount that)) return false;
        return Float.compare(that.profit, profit) == 0 && Float.compare(that.revenues, revenues) == 0 && Float.compare(that.costs, costs) == 0 && Objects.equals(userName, that.userName);
    }

    /**
     * Gets sellers hexadecimal memory address for each of it's properties
     * @return hexadecimal digits
     */
    @Override
    public int hashCode() {
        return Objects.hash(userName, profit, revenues, costs);
    }

    private String userName;
    private float profit;
    private float revenues;
    private float costs;
}

