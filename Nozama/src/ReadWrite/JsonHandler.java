package ReadWrite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandler
{
    JSONParser jsonParser = new JSONParser();

    public JSONArray getJSONArrayFromJson(String filename)
    {
        try (FileReader reader = new FileReader(filename))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray data = (JSONArray) obj;

            return data;
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }

    }


}
