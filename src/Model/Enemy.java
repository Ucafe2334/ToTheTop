package Model;

import Model.Abstract.Characters;
import Model.Abstract.Item;

public class Enemy extends Characters {
    private Item[] dropitem;

    public Enemy(String playerName, String desc, int hp, int mp, int pa, int ma, int deff, int spd) {
        this.name = playerName;
        this.desc = desc;

        this.HP = hp;
        this.MP = mp;
        this.MaxHP = hp;
        this.MaxMP = mp;
        this.PA = pa;
        this.MA = ma;
        this.deff = deff;
        this.speed = spd;

    }

    public Item[] getDropitem() {
        return dropitem;
    }

    public void setDropitem(Item[] dropitem) {
        this.dropitem = dropitem;
    }
}
