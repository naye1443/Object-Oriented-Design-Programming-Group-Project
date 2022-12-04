package DataTypes;

public interface IItem
{
//    Bundle bundleItem(IItem ... items);

    String getSellPrice();

    boolean isBundle();

    int getQuantity();

    SellerAccount getVendor();

    String getName();

}
