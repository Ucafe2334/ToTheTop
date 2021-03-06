package Model;

import Model.Abstract.BasicAttribute;
import Model.Enum.TypeAttribute;

public class Skill extends BasicAttribute {
    private int basePA = 0;
    private int baseMA = 0;
    private int percentagePA = 0;
    private int percentageMA = 0;
    private int manaCost = 0;
    private final boolean self;
    private int cost;
    TypeAttribute attribute;

    public Skill(String name, String desc, int basePA, int percentagePA, int cost) {
        this.name = name;
        this.desc = desc;
        this.basePA = basePA;
        this.percentagePA = percentagePA;
        this.attribute = TypeAttribute.physical;
        this.self = false;
        this.cost = cost;
    }

    public Skill(String name, String desc, int baseMA, int percentageMA, int manaCost, int cost) {
        this.name = name;
        this.desc = desc;
        this.baseMA = baseMA;
        this.percentageMA = percentageMA;
        this.manaCost = manaCost;
        this.attribute = TypeAttribute.magic;
        this.self = false;
        this.cost = cost;
    }

    public Skill(String name, String desc, int MP, int HP,int percentageMA, int manaCost, int cost){
        this.name = name;
        this.desc = desc;
        this.MP = MP;
        this.HP = HP;
        this.percentageMA = percentageMA;
        this.manaCost = manaCost;
        this.attribute = TypeAttribute.buff;
        this.self = true;
        this.cost = cost;
    }

    public Skill(String name, String desc,int basePA, int percentagePA, int baseMA, int percentageMA, int manaCost, int cost) {
        this.name = name;
        this.desc = desc;
        this.basePA = basePA;
        this.percentagePA = percentagePA;
        this.baseMA = baseMA;
        this.percentageMA = percentageMA;
        this.manaCost = manaCost;
        this.attribute = TypeAttribute.physicalAndMagic;
        this.self = false;
        this.cost = cost;
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }
    public int getBasePA() {
        return basePA;
    }
    public int getBaseMA() {
        return baseMA;
    }
    public int getPercentagePA() {
        return percentagePA;
    }
    public int getPercentageMA() {
        return percentageMA;
    }
    public int getManaCost() {
        return manaCost;
    }
    public TypeAttribute getAttribute() {
        return attribute;
    }
    public Boolean getSelf(){
        return this.self;
    }
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }
}
