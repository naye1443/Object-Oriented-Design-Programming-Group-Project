package DataTypes;
import Model.NozamaSystem;

import java.util.ArrayList;
import java.util.Objects;

/**
 * author: Jamar ;D
 * Bundle Class will take an item and bundle that item together with an item or group of (IItem) items.
 */
public class Bundle implements IItem{

    //TODO:  Create a class that bundles items together and returns those(bundled) items to the cart-container.


    /**
     * Instantiate itemList array.
     */
    public Bundle(String bundleName, String vendorUsername, String quantity,Item ... items)
    {
        this.bundleName = bundleName;
        this.vendorUsername = vendorUsername;
        this.quantity = quantity;

        for (Item item : items)
        {
            itemList.add(item);
        }

    }

    public Bundle(String bundleName, String vendorUsername, String quantity)
    {
        this.bundleName = bundleName;
        this.vendorUsername = vendorUsername;
        this.quantity = quantity;

    }

//    @Override
//    public Bundle bundleItem(IItem ... items)
//    {
//        return new Bundle(this.bundleName, this.vendorUsername, items);
//    }

    @Override
    public String toString()
    {
        String output = "Bundle: " + bundleName + "\n" +
                "Vendor: " + vendorUsername + "\n" +
                "Bundled Price: $" + getSellPrice() + "\n";

        for (Item item : itemList)
        {
            output += "Item: " + item.getName() + "\n" +
                    "Price: $" + item.getSellPrice() + " \n" +
                    "Description: " + item.getDescription() + " \n" +
                    "Quantity: " + item.getQuantity() + " \n";
            output += "\n";
        }
        return output;
    }

    public String getSellPrice()
    {
        float sum = 0;
        for (Item item : itemList)
        {
            sum += Float.parseFloat(item.getSellPrice()) * item.getQuantity();
            item.getSellPrice();
        }


        return Float.toString(sum);
    }

    @Override
    public boolean isBundle() {
        return true;
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(this.quantity);
    }

    @Override
    public SellerAccount getVendor() {

        return NozamaSystem.getInstance().getSeller(vendorUsername);
    }

    @Override
    public String getName() {
        return bundleName;
    }

    public void addItem(Item item)
    {
        itemList.add(item);
    }

    public ArrayList<Item> getItemList()
    {
        return itemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bundle bundle)) return false;
        return Objects.equals(itemList, bundle.itemList) && Objects.equals(bundleCost, bundle.bundleCost) && Objects.equals(vendorUsername, bundle.vendorUsername) && Objects.equals(quantity, bundle.quantity) && Objects.equals(bundleName, bundle.bundleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemList, bundleCost, vendorUsername, quantity, bundleName);
    }

    private ArrayList<Item> itemList = new ArrayList<>();
    private String bundleCost;
    private String vendorUsername;
    private String quantity;
    private String bundleName;
}
