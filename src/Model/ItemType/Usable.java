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

}
