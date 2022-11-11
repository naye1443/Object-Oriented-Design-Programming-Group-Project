package DataTypes;

public interface IItem
{
    Bundle bundleItem(IItem ... items);

    String getPrice();
}
