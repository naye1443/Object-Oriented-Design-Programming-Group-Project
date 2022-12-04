package DataTypes;

import Model.NozamaSystem;
import NozamaGui.Screens.CustomerDashboard;
import NozamaGui.Screens.SellerDashboard;
import ReadWrite.Json.JSONObject;

import java.util.Objects;

public class SellerAccount implements IAccount{

    /**
     * Constructor
     * @author Jordan Diaz
     */
    public SellerAccount(String username, float profit, float revenues, float costs)
    {

        this.userName = username;
        this.profit = profit;
        this.revenues = revenues;
        this.costs = costs;
    }

    @Override
    public void OnLogIn()
    {
        System.out.println("A seller has logged in");
        SellerDashboard sellerDashboard = new SellerDashboard(this);
    }

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

    public String getUserName(){
        return userName;
    }

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

    public float getRevenues() {
        return revenues;
    }

    public float getCosts() {
        return costs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SellerAccount that)) return false;
        return Float.compare(that.profit, profit) == 0 && Float.compare(that.revenues, revenues) == 0 && Float.compare(that.costs, costs) == 0 && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, profit, revenues, costs);
    }

    private String userName;
    private float profit;
    private float revenues;
    private float costs;
}

