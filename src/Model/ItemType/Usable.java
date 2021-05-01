package Model.ItemType;

import Model.Enum.TypeItem;
import Model.Abstract.Item;

public class Usable extends Item {

    public Usable(int id,String name, String desc, int hp, int mp,int cost) {
        super(id,name,desc,TypeItem.UsableItem,cost);
        this.HP = hp;
        this.MP = mp;
    }

}
