import ReadWrite.JsonHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NozamaSystem
{
    private static NozamaSystem instance;
    private JsonHandler jsonHandler = new JsonHandler();

    private JSONArray userData;


    private NozamaSystem(){}

    public static NozamaSystem getInstance()
    {
        if (instance == null)
        {
            instance = new NozamaSystem();
        }

        return instance;
    }

    private void parseUserDataObject(JSONObject user)
    {
        //Get the user object within the list
        JSONObject userObject = (JSONObject) user.get("000");


        //Get the username from the user object
        String username = (String) userObject.get("username");
        System.out.println(username);

        //Get the password from the user object
        String password = (String) userObject.get("password");
        System.out.println(password);

        //Get the accountType from the user object
        String accountType = (String) userObject.get("account");
        System.out.println(accountType);
    }

    public void loadUsersFromJson()
    {
        userData = jsonHandler.getJSONArrayFromJson("Nozama/testdata/users.json");
        parseUserDataObject((JSONObject) userData.get(0));
        System.out.println(userData);

    }

    public void printJson(String filename)
    {
        jsonHandler.getJSONArrayFromJson(filename);
    }



}
