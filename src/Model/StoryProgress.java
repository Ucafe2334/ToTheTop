package Model;

import Controller.Commands.BasicCommand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class StoryProgress {
    private final Player player;
    private int story;
    static private final String path = "src/Data/Story.json";
    private final Object obj;
    private final JSONObject jo;

    public StoryProgress(Player player) throws IOException, ParseException {
        this.player = player;
        this.story = 0;
        this.obj = new JSONParser().parse(new FileReader(path));
        this.jo = (JSONObject) obj;
    }

    public void generateStory(Integer proggres){
        String story = proggres.toString();
        JSONArray ja = (JSONArray) jo.get(story);
        for (Object o : ja) {
            JSONObject rec = (JSONObject) o;
            String nama = (String) rec.get("nama");
            String dialog = (String) rec.get("dialog");
            BasicCommand.npcTalk(nama, dialog);
        }
    }

    public void generateStory(String proggres){
        JSONArray ja = (JSONArray) jo.get(proggres);
        for (Object o : ja) {
            JSONObject rec = (JSONObject) o;
            String nama = (String) rec.get("nama");
            String dialog = (String) rec.get("dialog");
            BasicCommand.npcTalk(nama, dialog);
        }
    }

    public void progress(){
        BasicCommand.npcTalk("Pembawa Acara",
                "pertandingan selesai!!! dan dimenangkan oleh "+player);
        BasicCommand.npcTalk("Pembawa Acara",
                "pertandingan selanjutnya akan dimulai akan dimulai 1 jam lagi");
        BasicCommand.npcTalk("Pembawa Acara",
                "semua peserta turnamen dipersilakan untuk beristirahat");
    }

    public void winning(){
        BasicCommand.npcTalk("Pembawa Acara",
                "pertandingan selesai!!! dan dimenangkan oleh "+player);
        BasicCommand.npcTalk("Pembawa Acara",
                "selamat untuk pemenang!! hadiah akan diberikan langsung oleh raja");
        BasicCommand.npcTalk("",
                "pengelana itu memenangkan pertandingan dan mendapatkan hadiah yang dia inginkan");
        BasicCommand.tittle("TAMAT");
    }

    public void gameover(){
        BasicCommand.npcTalk("",
                "pengelana itu tidak menang dan harus pulang dengan tangan kosong");
        BasicCommand.tittle("GAMEOVER");
    }

    public Player getPlayer() {
        return player;
    }

    public int getStory() {
        return story;
    }

    public JSONObject getJo() {
        return jo;
    }

    public void setStory(int story) {
        this.story = story;
    }
}
