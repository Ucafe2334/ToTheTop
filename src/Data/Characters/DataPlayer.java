package Data.Characters;

import Data.DataCharacters;
import Model.Player;


public class DataPlayer extends DataCharacters {

    public DataPlayer(){
        this.DataChar.put(1, new Player("Manusia",
                "ras manusia punya tekad yang kuat untuk memenangkan suatu peperangan dan menjadi pahlawan",
                1000,1000,200,200,100,200));
        this.DataChar.put(2, new Player("Dwarf",
                "Dwarf rupanya yang seperti manusia, namun berukuran lebih kecil dan pendek.\nMereka berjanggut panjang dan tampak lebih tua dari ukuran tubuhnya.",
                2000,0,160,120,180,280));
        this.DataChar.put(3, new Player("Elf",
                "Elf biasanya berwujud manusia yang sangat kecil dan biasanya mempunyai tugas sebagai dewa kesuburan.",
                800,2000,120,380,80,180));
        this.DataChar.put(4, new Player("Demon",
                "ras satu ini pada awalnya berdiri sejajar dengan para angel, namun karena dia membangkang akhirnya dikutuk oleh Tuhan.",
                1200,1500,280,240,100,160));
        this.DataChar.put(5, new Player("Lizardmen",
                "Tubuh mereka ditutupi sisik dengan pewarnaan dalam nuansa hijau yang berbeda antar individu, yang biasanya mereka warisi dari orang tua mereka.",
                1200,1500,280,120,120,200));
    }

    public Player getChar(int id){
        return (Player) DataChar.get(id);
    }
}
