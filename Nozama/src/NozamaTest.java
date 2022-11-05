import java.util.ArrayList;

public class NozamaTest
{
    public static void main(String[] args) {
        System.out.println("Hello, welcome to Nozama!");

        NozamaSystem instance = NozamaSystem.getInstance();

        System.out.println(instance.getUserUsername("000"));
        System.out.println();

        System.out.println(instance.getUserPassword("000"));
        System.out.println();

        System.out.println(instance.getUserAccountType("000"));
        System.out.println();

        System.out.println(instance.logIn("username", "password"));
        System.out.println();

        instance.printUserData();

        System.out.println();

        for (Item item : instance.getInventory())
        {
            System.out.println(item);
        }

    }
}
