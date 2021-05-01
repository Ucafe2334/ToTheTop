package Data.Characters;

import Data.DataCharacters;
import Model.Abstract.Characters;
import Model.Enemy;
import Model.Skill;

public class DataEnemy extends DataCharacters {
    public DataEnemy(){
        this.DataChar.put(1, new Enemy("Humans",
                "",
                1000,1000,150,150,70,100,
                new Skill("No Mercy",
                        "",
                        200,150,200,150,200)));
        this.DataChar.put(2, new Enemy("Orc",
                "",
                1500,0,200,0,100,50,
                new Skill("Berserk Mode",
                        "",
                        500,100)));
        this.DataChar.put(3, new Enemy("Elf",
                "",
                800,1500,100,200,50,80,
                new Skill("Penetrate Shot",
                        "",
                        300,200,100)));
    }

    @Override
    public Enemy getChar(int id) {
        return (Enemy) this.DataChar.get(id);
    }
}
