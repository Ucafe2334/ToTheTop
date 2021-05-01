package Model;

import Model.Abstract.Characters;
import Model.Abstract.Item;

public class Enemy extends Characters {
    private final Skill skill;
    private Item[] dropItem;

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

    public Item[] getDropItem() {
        return dropItem;
    }
    public Skill getSkill() {
        return skill;
    }

    public void setDropItem(Item[] dropItem) {
        this.dropItem = dropItem;
    }
}
