package Model.ItemType;

import Model.Enum.TypeItem;
import Model.Enum.TypeEquip;
import Model.Abstract.Item;

public class Equipable extends Item{
    public TypeEquip equipType;
    public Equipable(String name, String desc, int hp, int mp, int pa, int ma, int deff, int spd, TypeEquip typeE,int cost) {
        super(name,desc,TypeItem.EquipableItem,cost);

        this.HP = hp;
        this.MP = mp;
        this.PA = pa;
        this.MA = ma;
        this.def = deff;
        this.speed = spd;

        this.equipType = typeE;
    }
}
