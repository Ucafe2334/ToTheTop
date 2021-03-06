package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class SkillReader {
    static String json = "/src/Data/SkillData.json";
    static public String data;

    public static void main(String[] args) {
        try {
            Object obj = new JSONParser().parse(new FileReader("src/Data/SkillData.json"));

            JSONObject jo = (JSONObject) obj;

            JSONObject one = (JSONObject) jo.get("2");
            String name = (String) one.get("name");
            System.out.println(name);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}