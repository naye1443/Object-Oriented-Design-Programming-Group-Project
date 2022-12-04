package DataTypes;

import Model.NozamaSystem;

import java.util.Objects;

/**
 * Item class creates the behaviors of each item object.
 */
public class Item implements IItem
{
    private String ID, name, invoicePrice, sellPrice, description, quantity, vendor;

    /**
     * Item parametrized Constructor defines an Item object properties.
     * @param id - item barcode
     * @param name - item name
     * @param invoicePrice - item price
     * @param sellPrice - item selling price
     * @param description - item details
     * @param quantity - item count
     * @param vendor - item manufacturer
     */
    public Item(String id, String name, String invoicePrice, String sellPrice, String description, String quantity, String vendor)
    {
        this.ID = id;
        this.name = name;
        this.invoicePrice = invoicePrice;
        this.sellPrice = sellPrice;
        this.description = description;
        this.quantity = quantity;
        this.vendor = vendor;
    }

    /**
     * Overrides default toString method, to create custom toString output string.
     * @return string
     */
    @Override
    public String toString() {
        return "Item: " + name + " \n" +
                //"Invoice Price: $" + invoicePrice + " \n" +
                "Price: $" + sellPrice + " \n" +
                "Description: " + description + " \n" +
                "Quantity: " + quantity + " \n" +
                "Vendor: " + vendor + " \n";
    }

    /**
     * Gets item's id property
     * @return string
     */
    public String getID(){
        return this.ID;
    }

    /**
     * Gets item's name property
     * @return string
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets item's sellPrice property
     * @return string
     */
    public String getSellPrice(){
        return this.sellPrice;
    }

    /**
     * Confirms that an Item object is not a type Bundle
     * @return boolean
     */
    @Override
    public boolean isBundle() {
        return false;
    }

    /**
     * Gets item's quantity property
     * @return integer
     */
    public int getQuantity() { return Integer.parseInt(this.quantity); }

    /**
     * Grab item's vendor description
     * @return string
     */
    public SellerAccount getVendor()
    {
        return NozamaSystem.getInstance().getSeller(vendor);
    }

//    @Override
//    public Bundle bundleItem(IItem ... items)
//    {
//        return new Bundle(items);
//    }

    /**
     * Gets item's invoicePrice property
     * @return integer
     */
    public String getInvoicePrice() {
        return invoicePrice;
    }

    /**
     * Gets item's description property
     * @return string
     */
    public String getDescription() {
        return description;
    }

    /**
     * Object override comparison method, object that calls this method is testing if the same as object that's passed as argument.
     * @param o - Object passed by argument
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(ID, item.ID) && Objects.equals(name, item.name) && Objects.equals(sellPrice, item.sellPrice) && Objects.equals(description, item.description) && Objects.equals(quantity, item.quantity);
    }

    /**
     * Gets an item's hexadecimal memory address for each of it's properties
     * @return hexadecimal digits
     */
    @Override
    public int hashCode() {
        return Objects.hash(ID, name, sellPrice, description, quantity);
    }
}
