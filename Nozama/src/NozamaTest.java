public class NozamaTest
{
    public static void main(String[] args) {
        System.out.println("Hello, welcome to Nozama!");
        NozamaSystem instance = NozamaSystem.getInstance();

        instance.loadUsersFromJson();
    }
}
