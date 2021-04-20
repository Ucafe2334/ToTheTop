package Model.ItemType;

import Model.Item;
import Model.Player;

public class Usable extends Item {

    public Usable(String name, String desc, int hp, int mp) {
        this.name = name;
        this.desc = desc;
        this.HP = hp;
        this.MP = mp;
        this.itemType = type.USABLE;
    }

    public void useItem(Player player){
        System.out.println("Using Item "+getName());

        if (this.HP > 0){
            player.setHP(player.getHP()+this.HP);
            if (player.getMaxHP() < player.getHP()){
                player.setHP(player.getMaxHP());
            }
            System.out.println(player.getName()+" recovery "+this.HP+"HP");
        }
        if (this.MP > 0){
            player.setHP(player.getMP()+this.MP);
            if (player.getMaxMP() < player.getMP()){
                player.setMP(getMaxMP());
            }
            System.out.println(player.getName()+ " recovery "+this.MP+"MP");
        }
    }

}
