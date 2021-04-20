package Model;

public class Enemy extends Characters {
    Item[] dropitem;

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
}
