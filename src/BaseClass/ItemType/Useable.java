package BaseClass.ItemType;

import BaseClass.Item;

public class Useable extends Item {
    private boolean selfEffect;
    private boolean use;
    private int turn;

    public Useable(String name, String desc, int hp, int mp, int ap, int deff, int Speed) {
        this.Name = name;
        this.Desc = desc;
        this.Type = "Useable";
        this.HP = hp;
        this.MP = mp;
        this.AP = ap;
    }

    public void useItem(){

    }

    public void itemEffect(){

    }
}
