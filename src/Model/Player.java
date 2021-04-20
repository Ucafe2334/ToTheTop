package Model;

import Model.ItemType.Equipable;

public class Player extends Characters {
    //equiped
    private Equipable weapons;//weapon yang di equip
    private Equipable secondaryWeapons;//weapon ke 2 yang di equip
    private Equipable armor;//armor yang di equip
    private Equipable accessories;//accesories yang di equip

    //inventory
    private Item[] inventory;
    private int Cap;

    //constructor
    public Player(String playerName, String desc, int hp, int mp, int pa, int ma, int deff, int spd) {
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

    public Equipable getSecondaryWeapons() {
        return secondaryWeapons;
    }
    public Equipable getWeapons() {
        return weapons;
    }
    public Equipable getArmor() {
        return armor;
    }
    public Equipable getAccessories() {
        return accessories;
    }
    public Item[] getInventory() {
        return inventory;
    }
    public int getCap() {
        return Cap;
    }

    public void setSecondaryWeapons(Equipable secondaryWeapons) {
        this.secondaryWeapons = secondaryWeapons;
    }
    public void setWeapons(Equipable weapons) {
        this.weapons = weapons;
    }
    public void setArmor(Equipable armor) {
        this.armor = armor;
    }
    public void setAccessories(Equipable accessories) {
        this.accessories = accessories;
    }
    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }
    public void setCap(int cap) {
        Cap = cap;
    }
}
