package Model;

import Model.Abstract.Characters;
import Model.Abstract.Item;

public class Enemy extends Characters {
    private Skill skill;
    private int dropGold;

    public Enemy(String playerName, String desc, int hp, int mp, int pa, int ma, int def, int spd, Skill skill) {
        this.name = playerName;
        this.desc = desc;

        this.HP = hp;
        this.MP = mp;
        this.MaxHP = hp;
        this.MaxMP = mp;
        this.PA = pa;
        this.MA = ma;
        this.def = def;
        this.speed = spd;

        this.skill = skill;
    }

    public Enemy(String playerName, String desc, int hp, int mp, int pa, int ma, int def, int spd, int drop) {
        this.name = playerName;
        this.desc = desc;

        this.HP = hp;
        this.MP = mp;
        this.MaxHP = hp;
        this.MaxMP = mp;
        this.PA = pa;
        this.MA = ma;
        this.def = def;
        this.speed = spd;

        this.dropGold = drop;
    }


    public Skill getSkill() {
        return skill;
    }

    public int getDropGold() {
        return dropGold;
    }
}
