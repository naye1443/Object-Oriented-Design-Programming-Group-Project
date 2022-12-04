package DataTypes;
import Model.NozamaSystem;

import java.util.ArrayList;
import java.util.Objects;

/**
 * author: Jamar
 * Bundle Class will take an item and bundle that item together with another item or group of (IItem) items.
 */
public class Bundle implements IItem{
    /**
     * Parameterized constructor takes in a group of (Item or IItem) item(s), quantity, bundleName, and vendorUsername.
     * Instantiates itemList array of bundled items.
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

    /**
     * Parameterized constructor takes in a bundle's quantity, bundleName, and vendorUsername.
     * Instantiate itemList array of items.
     */
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

    /**
     * Overrides toString method with custom getter methods, to create a customized string.
     * @return a string that consist all it's item(s) properties
     */
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

    /**
     * Getter method that does a summation of all items in itemList prices together in the bundle object.
     * @return integer(string sum)
     */
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

    /**
     * Confirms that a bundle object is of type bundle
     * @return Boolean
     */
    @Override
    public boolean isBundle() {
        return true;
    }

    /**
     * Gets bundle's quantity amount
     * @return integer amount of the item's quantity
     */
    @Override
    public int getQuantity() {
        return Integer.parseInt(this.quantity);
    }

    /**
     * Gets bundle's vendor description
     * @return string of the item's vendor name
     */
    @Override
    public SellerAccount getVendor() {

        return NozamaSystem.getInstance().getSeller(vendorUsername);
    }

    /**
     * Gets bundle's name description
     * @return string of item's name
     */
    @Override
    public String getName() {
        return bundleName;
    }

    /**
     * Appends an item to itemList
     */
    public void addItem(Item item)
    {
        itemList.add(item);
    }

    /**
     * Gets itemList Item array
     * @return class member itemList
     */
    public ArrayList<Item> getItemList() {return itemList;}

    /**
     * Object override comparison method, object that calls this method is testing if the same as object that's passed as argument.
     * @param o - Object passed by argument
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bundle bundle)) return false;
        return Objects.equals(itemList, bundle.itemList) && Objects.equals(bundleCost, bundle.bundleCost) && Objects.equals(vendorUsername, bundle.vendorUsername) && Objects.equals(quantity, bundle.quantity) && Objects.equals(bundleName, bundle.bundleName);
    }

    /**
     * Gets a bundle's hexadecimal memory address for each of it's properties
     * @return hexadecimal digits
     */
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
