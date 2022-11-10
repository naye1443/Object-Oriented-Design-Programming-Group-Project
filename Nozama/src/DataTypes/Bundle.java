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
    Bundle() {
        this.itemList = new ArrayList<IItem>();
    }

    /**
     * Assign each bundle with an index in the itemList array.
     * @param addItem - item to be appended to itemList.
     */
    public void bundleItem(IItem addItem){
        this.itemList.add(addItem);
    }

    /**
     * Remove an item from a bundle by index.
     * @param removeItem - item to be removed
     */
    public void removeItem(IItem removeItem){
        //TODO:  Create precondition
        for(IItem item : this.itemList){
            if(item.equals(removeItem)) {
                this.itemList.remove(item);
            }
        }
    }
    /**
     * Getter Method, returns bundle.
     * @return - returns a list of bundles
     */
    public IItem getBundle(){
        //TODO:  Create precondition
        //Append a IItem bundle as an element to cartcontainer arrayList.
        return (IItem) this.itemList;
    }









    @Override
    public Item bundleItem() {
        return null;
    }
    private ArrayList<IItem> itemList;
    private float bundleCost;
}
