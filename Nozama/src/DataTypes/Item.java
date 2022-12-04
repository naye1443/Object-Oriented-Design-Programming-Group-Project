package DataTypes;

import Model.NozamaSystem;

import java.util.Objects;

public class Item implements IItem
{
    private String ID, name, invoicePrice, sellPrice, description, quantity, vendor;

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
     * @returns ID of item
     */
    public String getID(){
        return this.ID;
    }

    /**
     * @returns name of item
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return returns price of item
     */
    public String getSellPrice(){
        return this.sellPrice;
    }

    @Override
    public boolean isBundle() {
        return false;
    }

    /**
     * @return returns quantity of item
     */
    public int getQuantity() { return Integer.parseInt(this.quantity); }

    public SellerAccount getVendor()
    {
        return NozamaSystem.getInstance().getSeller(vendor);
    }

//    @Override
//    public Bundle bundleItem(IItem ... items)
//    {
//        return new Bundle(items);
//    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(ID, item.ID) && Objects.equals(name, item.name) && Objects.equals(sellPrice, item.sellPrice) && Objects.equals(description, item.description) && Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, sellPrice, description, quantity);
    }
}
