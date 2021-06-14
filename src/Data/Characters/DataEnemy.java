package Data.Characters;

import Data.DataCharacters;
import Model.Abstract.Characters;
import Model.Enemy;
import Model.Skill;

public class DataEnemy extends DataCharacters {
    public DataEnemy(){
        this.DataChar.put(1, new Enemy("Carlos",
                "Seorang pemburu handal yang datang dari kota Z, dia ke sini dengan tujuan mengubah hidupnya\n",
                1000,1000,150,150,70,100,
                new Skill("No Mercy",
                        "",
                        200,150,200,150,200,0)));
        this.DataChar.put(2, new Enemy("Orc Pinter",
                "seorang monster yang bisa berinteraksi dengan manusia, dia kesini dengan tujuan \nmembersihkan namanya dari kejahata yang pernah dia lakukan\n",
                2500,0,200,0,100,50,
                new Skill("Berserk Mode",
                        "",
                        500,100,0)));
        this.DataChar.put(3, new Enemy("Pemburu Handal",
                "seorang pemburu yang sangat disegani oleh siapapun, tahun lalu dia hampir saja mena\nakan tetapi dikalahkan saat babak final",
                8000,1500,400,300,400,300,
                new Skill("Penetrate Shot",
                        "",
                        300,100,400,0)));
    }

    @Override
    public Enemy getChar(int id) {
        return (Enemy) this.DataChar.get(id);
    }
}
