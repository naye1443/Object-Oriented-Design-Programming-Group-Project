package DataTypes;

import java.util.Objects;

public class Item implements IItem
{
    private String ID, name, price, description, quantity;

    public Item(String id, String name, String price, String description, String quantity)
    {
        this.ID = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item: " + name + " \n" +
                "Price: $" + price + " \n" +
                "Description: " + description + " \n" +
                "Quantity: " + quantity + " \n";
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
    public String getPrice(){
        return this.price;
    }

    @Override
    public boolean isBundle() {
        return false;
    }

    /**
     * @return returns quantity of item
     */
    public int getQuantity() { return Integer.parseInt(this.quantity); }

    @Override
    public Bundle bundleItem(IItem ... items)
    {
        return new Bundle(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(ID, item.ID) && Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(description, item.description) && Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price, description, quantity);
    }
}
