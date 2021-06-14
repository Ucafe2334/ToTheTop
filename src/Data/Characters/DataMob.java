package Data.Characters;

import Data.DataCharacters;
import Model.Enemy;
import Model.Skill;

public class DataMob extends DataCharacters {
    public DataMob(){
        this.DataChar.put(1, new Enemy("Goblin",
                "makhluk bertelinga panjang dan berwarna hijau",
                800,0,150,0,80,160, 100));
        this.DataChar.put(2, new Enemy("Gnome",
                "makhluk kecil memakai topi",
                1000,0,150,0,80,240, 300));
        this.DataChar.put(3, new Enemy("Werewolf",
                "makhluk setengah serigala",
                1300,0,380,0,160,200, 500));
        this.DataChar.put(4, new Enemy("Ghoul",
                "makhluk setengah mayat",
                3000,0,300,0,120,160, 800));
        this.DataChar.put(5, new Enemy("Orc",
                "makhluk besar berwarna hijau",
                2000,0,800,0,150,280, 1000));
        this.DataChar.put(6, new Enemy("Titan",
                "makhluk besar setinggi 2 meter",
                3000,0,1000,0,150,280, 2000));
    }

    @Override
    public Enemy getChar(int id) {
        return (Enemy) this.DataChar.get(id);
    }
}
