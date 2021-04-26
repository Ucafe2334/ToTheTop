package Model.ItemType;

import Model.Enum.TypeItem;
import Model.Item;
import Model.Player;

public class Usable extends Item {

    public Usable(String name, String desc, int hp, int mp,int cost) {
        super(name,desc,TypeItem.UsableItem,cost);
        this.HP = hp;
        this.MP = mp;
    }

}
