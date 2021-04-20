package Data;

import Model.Player;

import java.util.HashMap;
import java.util.Map;

public class DataEnemy {
    private final HashMap<Integer, Player> DataPlayer = new HashMap<>();

    public DataEnemy(){
        this.DataPlayer.put(1, new Player("Humans","",1000,1000,150,150,70,100));
        this.DataPlayer.put(2, new Player("Orc","",1500,0,200,0,200,50));
        this.DataPlayer.put(3, new Player("Elf","",800,1500,100,200,50,80));
    }

    public void getPlayer(){
        for (Map.Entry<Integer,Player> entry: DataPlayer.entrySet()){
            Integer id = entry.getKey();
            Player idPlayer = entry.getValue();

            System.out.println(id + "> " + idPlayer.getName());
            System.out.println("HP : " + idPlayer.getMaxHP());
            System.out.println("MP : " + idPlayer.getMaxMP());
            System.out.println("PA/MA/DEF/SPD");
            System.out.println(idPlayer.getPA() + "/" + idPlayer.getMA() + "/" + idPlayer.getDeff() + "/" + idPlayer.getSpeed());
            System.out.println(" ");
        }
    }

    public Player getPlayer(int id){
        return DataPlayer.get(id);
    }
}
