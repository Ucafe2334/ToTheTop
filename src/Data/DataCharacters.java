package Data;

import Model.Abstract.Characters;

import java.util.HashMap;
import java.util.Map;

public abstract class DataCharacters {
    protected final HashMap<Integer, Characters> DataChar = new HashMap<>();
    public void getChar(){
        for (Map.Entry<Integer, Characters> entry: DataChar.entrySet()){
            Integer id = entry.getKey();
            Characters idChar = entry.getValue();

            System.out.println(id + "> " + idChar);
            System.out.println("HP : " + idChar.getMaxHP());
            System.out.println("MP : " + idChar.getMaxMP());
            System.out.println("desc :\n" + idChar.getDesc());
            System.out.println("PA/MA/DEF/SPD");
            System.out.println(idChar.getPA() + "/" + idChar.getMA() + "/" + idChar.getDef() + "/" + idChar.getSpeed());
            System.out.println(" ");
        }
    }

    public Characters getChar(int id){
        return DataChar.get(id);
    }
}
