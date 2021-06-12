package Data.Characters;

import Data.DataCharacters;
import Model.Player;


public class DataPlayer extends DataCharacters {

    public DataPlayer(){
        this.DataChar.put(1, new Player("Humans","",1000,1000,150,150,70,100));
        this.DataChar.put(2, new Player("Orc","",1500,0,200,0,100,50));
        this.DataChar.put(3, new Player("Elf","",800,1500,100,200,50,80));
    }

    public Player getChar(int id){
        return (Player) DataChar.get(id);
    }
}
