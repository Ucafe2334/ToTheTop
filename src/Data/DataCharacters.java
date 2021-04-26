package Data;

import Model.Characters;
import Model.Enum.TypeItem;
import Model.Item;
import Model.Player;

import java.util.HashMap;
import java.util.Map;

public class DataCharacters {
    protected final HashMap<Integer, Characters> DataChar = new HashMap<>();
    public void getChar(){
        for (Map.Entry<Integer, Characters> entry: DataChar.entrySet()){
            Integer id = entry.getKey();
            Characters idChar = entry.getValue();

            System.out.println(id + "> " + idChar.getName());
            System.out.println("HP : " + idChar.getMaxHP());
            System.out.println("MP : " + idChar.getMaxMP());
            System.out.println("PA/MA/DEF/SPD");
            System.out.println(idChar.getPA() + "/" + idChar.getMA() + "/" + idChar.getDeff() + "/" + idChar.getSpeed());
            System.out.println(" ");
        }
    }

    public Characters getChar(int id){
        return DataChar.get(id);
    }
}
