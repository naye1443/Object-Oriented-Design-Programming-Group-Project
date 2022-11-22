package DataTypes;
import java.util.ArrayList;
/**
 * author: Jamar ;D
 * Bundle Class will take an item and bundle that item together with an item or group of (IItem) items.
 */
public class Bundle implements IItem{

    //TODO:  Create a class that bundles items together and returns those(bundled) items to the cart-container.


    /**
     * Instantiate itemList array.
     */
    public Bundle(IItem ... items)
    {
        for (IItem item : items)
        {
            itemList.add(item);
        }

    }

    @Override
    public Bundle bundleItem(IItem ... items)
    {
        return new Bundle(items);
    }

    @Override
    public String toString()
    {
        String output = "Bundle: \n";

        for (IItem item : itemList)
        {
            output += item.toString();
            output += "\n";
        }
        return output;
    }

    public String getPrice()
    {
        float sum = 0;
        for (IItem item : itemList)
        {
            sum += Float.parseFloat(item.getPrice());
            item.getPrice();
        }


        return Float.toString(sum);
    }

    @Override
    public boolean isBundle() {
        return true;
    }

    private ArrayList<IItem> itemList = new ArrayList<>();
    private String bundleCost;
}
