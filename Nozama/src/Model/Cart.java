package Model;
import DataTypes.ICoupon;
import DataTypes.IItem;



import java.util.ArrayList;

/*
 * This is a class that is part of a DataTypes.CustomerAccount
 *
 * */
public class Cart implements ICoupon {
  /**
   * Constructor
   * @Author Eyan
   */
  public Cart(){
    CartContainer = new ArrayList<IItem>();
    CartQuantities = new ArrayList<>();
  }

  /**
   * Returns Container list
   */
  public ArrayList<IItem> getCart(){
    return CartContainer;
  }

  /**
   * Add a new item to the Arraylist
   * @param newItem DataTypes.IItem to add to cart
   */
  public void addItem(IItem newItem, int quantity){

    if (CartContainer.contains(newItem))
    {

      int index = CartContainer.indexOf(newItem);

      int updatedQuantity = quantity + CartQuantities.get(index);

      if (updatedQuantity > newItem.getQuantity())
      {
        cartMessage = "There are no more of this item";
      }
      else
      {
        cartMessage = "Cart updated";
        CartQuantities.set(index, updatedQuantity);
      }

    }
    else
    {
      cartMessage = "Item Added";
      CartContainer.add(newItem);
      CartQuantities.add(quantity);
    }


  }

  /**
   * Removes DataTypes.IItem from CartContainer
   * @param removedItem - item or bundle to be removed.
   */
  public void removeItem(IItem removedItem, int quantity)
  {
    if (CartContainer.contains(removedItem))
    {
      int index = CartContainer.indexOf(removedItem);
      int currentQuantity = CartQuantities.get(index);

      if (currentQuantity == quantity)
      {
        CartContainer.remove(index);
        CartQuantities.remove(index);
      }
      else if (currentQuantity > quantity)
      {
        System.out.println("this is being run");
        CartQuantities.set(index, currentQuantity - quantity);
      }
    }
    //CartContainer.removeIf(item -> item.equals(removedItem));
  }

  public void viewCart(){
    for(IItem item : CartContainer){
      System.out.println(item.toString());
    }
  }

  /**
   * @Author: Jamar
   * Adds each item/bundle in cart.
   * @return - Grand total for each item/bundle in cart.
   */
  public float getTotal(){
    total = 0;
    int index = 0;
    for(IItem item : CartContainer){
      total += Float.parseFloat(item.getSellPrice()) * CartQuantities.get(index);
      index += 1;
    }

    return total;
  }

  public float getTotalWithCoupons(){
    if (totalWithCoupons == 0){
      totalWithCoupons = total;
    }
    return totalWithCoupons;
  }

  public void setTotalWithCoupons(float value)
  {
    totalWithCoupons = value;
  }


  public int getQuantity(int index)
  {
    return CartQuantities.get(index);
  }

  /**
   * Tells Model.NozamaSystem to process payment And remove items from SellerAccount inventory
   */
  public void checkout(){
    //TODO Model.NozamaSystem.ProcessPayment(/*Final discounted price goes here*/);  // returns true or false to see if payment continues thorough.
    //TODO destroy cart. No longer needed.
  }

  /**
   * @Author: Jamar (Decorator Pattern).
   * @return: total for concrete class used by the decorator.
   */

  public String getDescription() {
    return "Basic cart no coupons added yet";
  }
//
//  public void AddFivePercentCoupon() {
//    coupon = new ApplyFiveOff(this);
//  }

//
//  public float AddTenPercentCoupon() {
//    return total;
//  }

  protected ArrayList<IItem> CartContainer;
  protected ArrayList<Integer> CartQuantities;
  private float total;

  private float totalWithCoupons;
  public String cartMessage;

  public ICoupon coupon;


}