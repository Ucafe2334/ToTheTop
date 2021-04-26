package Model;

import Controller.Commands.PlayerCommands;
import Model.Enum.TypeItem;
import Model.ItemType.Equipable;

import java.util.ArrayList;

public class Player extends Characters {
    //equiped
    private Equipable weapons;//weapon yang di equip
    private Equipable secondaryWeapons;//weapon ke 2 yang di equip
    private Equipable armor;//armor yang di equip
    private Equipable accessories;//accesories yang di equip

    //inventory
    private final ArrayList<Item> inventory;

    //constructor
    public Player(String playerName, String desc, int hp, int mp, int pa, int ma, int deff, int spd) {
        this.name = playerName;
        this.desc = desc;

        this.weapons = new Equipable();
        this.secondaryWeapons = new Equipable();
        this.armor = new Equipable();
        this.accessories = new Equipable();

        this.HP = hp;
        this.MP = mp;
        this.MaxHP = hp;
        this.MaxMP = mp;
        this.PA = pa;
        this.MA = ma;
        this.deff = deff;
        this.speed = spd;
        this.inventory = new ArrayList<>();
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

    public void getInventory() {
        for (int i = 0; i < inventory.size(); i++){
            Item item = inventory.get(i);
            System.out.println(i+") "+item.getName());
        }
    }
    public void getInventory(TypeItem type) {
        for (int i = 0; i < inventory.size(); i++){
            Item item = inventory.get(i);
            if (item.getTypeI() == type){
                System.out.println(i+") "+item.getName());
            }
        }
    }
    public Item getInventory(int id){
        return inventory.get(id);
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

    public void setInventory(Item item) {
        this.inventory.add(item);
    }
    public void removeItem(int id){
        this.inventory.remove(id);
    }
}
