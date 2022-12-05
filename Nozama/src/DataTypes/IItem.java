package DataTypes;

/**
 * @author Jordan
 * IItem interface writes the blueprint methods for Item class to implement.
 */
public interface IItem
{
//    Bundle bundleItem(IItem ... items);

    String getSellPrice();

    boolean isBundle();

    int getQuantity();

    SellerAccount getVendor();

    String getName();

}
