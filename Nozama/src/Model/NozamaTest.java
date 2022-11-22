package Model;

import DataTypes.ApplyTenOff;
import DataTypes.ApplyFiveOff;
import DataTypes.Bundle;
import DataTypes.Item;
import DataTypes.ICoupon;
import Model.NozamaSystem;


public class NozamaTest
{
    public static void main(String[] args) {
        NozamaSystem instance = NozamaSystem.getInstance();

        System.out.println(instance.logIn("username", "password"));

        System.out.println();

        for (Item item : instance.getInventory())
        {
            System.out.println(item);
        }

        System.out.println();
        System.out.println("Hello, welcome to Nozama!");


        Cart c = new Cart();
        Item i = new Item("99", "carrots", "33","carrotse bad", "1");
        Item j = new Item("100", "carrots", "38","cats gonbad", "1");
        Item k = new Item("101", "cas", "35","carrotsgone bad", "1");
        Item y = new Item("300", "catetes", "85"," bad", "1");
        Item z = new Item("181", "casds", "5","cargone ", "1");
        Bundle a = new Bundle(y, z);
        c.addItem(i, 1);
        System.out.println(c.getCart());


        System.out.println();
        System.out.println();
        System.out.println();
        Bundle b = i.bundleItem(i, j, k, a);
        System.out.println(b.toString());

        System.out.println(b.getPrice());


        //Add items to Cart
        System.out.println();
        System.out.println();
        System.out.println();
        c.addItem(i, 1);

        //Instantiate bundles
        Bundle b1 = i.bundleItem(j, k, a);
        Bundle b2 = i.bundleItem(a, k);
        System.out.println();

        //Add bundles to Cart
        c.addItem(b1, 1);
        c.addItem(b2, 1);

        //gets price of the bundle
        System.out.println(b1.getPrice());
        c.getTotal();
        System.out.println();

        //Remove getCart or viewCart?
        c.viewCart();
        System.out.println();

        //Test getTotal()
        System.out.println("Original Price: ");
        System.out.println(c.getTotal());

        //Decorator Testing
        System.out.println();
        ICoupon testing = new ApplyTenOff(new ApplyFiveOff(c));
        System.out.println(testing.getDescription());
        System.out.println(testing.AddTenPercentCoupon());

    }
}
