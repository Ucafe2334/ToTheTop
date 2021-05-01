package Model;

import Model.Abstract.BasicAttribute;

public class Skill extends BasicAttribute {
    private int basePA;
    private int baseMA;
    private int percentagePA;
    private int percentageMA;
    private int manaCost;

    public Skill() {
        this.name = "empty";
        this.desc = "";
    }

    public Skill(String name, String desc, int basePA, int percentagePA) {
        this.name = name;
        this.desc = desc;
        this.basePA = basePA;
        this.percentagePA = percentagePA;
    }

    public Skill(String name, String desc, int baseMA, int percentageMA, int manaCost) {
        this.name = name;
        this.desc = desc;
        this.baseMA = baseMA;
        this.percentageMA = percentageMA;
        this.manaCost = manaCost;
    }

    public Skill(String name, String desc, int MP, int HP,int percentageMA, int manaCost){
        this.name = name;
        this.desc = desc;
        this.MP = MP;
        this.HP = HP;
        this.percentageMA = percentageMA;
        this.manaCost = manaCost;

    }

    @Override
    public String getName() {
        return super.getName();
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
}
