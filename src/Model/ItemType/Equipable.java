package Model.ItemType;

import Model.Item;

public class Equipable extends Item{
    public enum typeE {WEAPONS,ARMOUR,ACCESSORIES,SECONDARY_WEAPONS}

    public typeE equipType;

    public Equipable(String name, String desc, int hp, int mp, int pa, int ma, int deff, int spd, typeE typee) {
        this.name = name;
        this.desc = desc;

        this.HP = hp;
        this.MP = mp;
        this.MaxHP = hp;
        this.MaxMP = mp;
        this.PA = pa;
        this.MA = ma;
        this.deff = deff;
        this.speed = spd;

        this.itemType = type.EQUIPABLE;
        this.equipType = typee;
    }
}
