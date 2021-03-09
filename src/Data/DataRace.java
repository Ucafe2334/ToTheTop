package Data;

import ClassData.Race;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DataRace {
    private final HashMap<Integer, Race> DataRace = new HashMap<>();

    public DataRace (){
        this.DataRace.put(1, new Race("Humans","",1000,100,1000,100,70,50,50,10));
        this.DataRace.put(2, new Race("Orc","",1500,0,1500,0,80,0,60,5));
        this.DataRace.put(3, new Race("Elf","",800,0,800,0,50,80,40,15));
    }

    public void getRace(){
        for (Map.Entry<Integer,Race> entry: DataRace.entrySet()){
            Integer id = entry.getKey();
            Race idRace = entry.getValue();

            System.out.println(id + "> " + idRace.getName());
            System.out.println("HP : " + idRace.getHP() + "/" + idRace.getMaxHP());
            System.out.println("MP : " + idRace.getMP() + "/" + idRace.getMAXMP());
            System.out.println("STR/INT/EN/AGI");
            System.out.println(idRace.getSTR() + "/" + idRace.getINT() + "/" + idRace.getEN() + "/" + idRace.getAGI());
            System.out.println(" ");
        }
    }

    public Race getRace(int id){
        return DataRace.get(id);
    }
}
