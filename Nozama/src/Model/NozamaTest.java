package Model;

import DataTypes.Bundle;
import DataTypes.Item;
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
        Item i = new Item("99", "carrots", "33","carrotse bad");
        Item j = new Item("100", "carrots", "38","cats gonbad");
        Item k = new Item("101", "cas", "35","carrotsgone bad");
        Item y = new Item("300", "catetes", "85"," bad");
        Item z = new Item("181", "casds", "5","cargone ");
        Bundle a = new Bundle(y, z);
        c.addItem(i);
        System.out.println(c.getCart());


        System.out.println();
        System.out.println();
        System.out.println();
        Bundle b = i.bundleItem(i, j, k, a);
        System.out.println(b.toString());

        System.out.println(b.getPrice());



    }
}
