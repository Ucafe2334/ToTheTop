package Data;

import Model.Enemy;
import Model.Player;

import java.util.HashMap;
import java.util.Map;

public class DataEnemy {
    private final HashMap<Integer, Enemy> DataPlayer = new HashMap<>();

    public DataEnemy(){
        this.DataPlayer.put(1, new Enemy("Humans","",1000,1000,150,150,70,100));
        this.DataPlayer.put(2, new Enemy("Orc","",1500,0,200,0,100,50));
        this.DataPlayer.put(3, new Enemy("Elf","",800,1500,100,200,50,80));
    }

    public Enemy getEnemy(int id){
        return DataPlayer.get(id);
    }
}
