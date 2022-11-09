public class Item implements IItem
{
    private String ID, name, price, description;

    public Item(String id, String name, String price, String description)
    {
        this.ID = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
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
     *
     * @return returns price of item
     */
    public String getPrice(){
        return this.price;
    }

    @Override
    public Item bundleItem() {
        return null;
    }
}
