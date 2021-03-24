package BaseClass.ItemType;

import BaseClass.Item;

public class Useable extends Item {
    private boolean selfEffect;

    public Useable(String name, String desc, boolean selfEffect, int hp, int mp) {
        this.selfEffect = selfEffect;
        this.Name = name;
        this.Desc = desc;
        this.Type = "Useable";
        this.HP = hp;
        this.MP = mp;
    }

    public void useItem(){

    }
}
