package Model;

import Model.Abstract.Characters;
import Model.Abstract.Item;
import Model.Enum.TypeItem;
import Model.ItemType.Equipable;

import java.util.ArrayList;

public class Player extends Characters{
    //equiped
    private Equipable weapons;//weapon yang di equip
    private Equipable secondaryWeapons;//weapon ke 2 yang di equip
    private Equipable armor;//armor yang di equip
    private Equipable accessories;//accesories yang di equip

    //skill slot
    private Skill slot1;
    private Skill slot2;
    private Skill slot3;

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

        this.slot1 = new Skill();
        this.slot2 = new Skill();
        this.slot3 = new Skill();

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

    //getter
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

    //inventory getter
    public void getInventory() {
        for (int i = 0; i < inventory.size(); i++){
            Item item = inventory.get(i);
            System.out.println((i+1)+") "+item.getName()+"\t x"+item.getQuantity());
        }
    }
    public void getInventory(TypeItem type) {
        for (int i = 0; i < inventory.size(); i++){
            Item item = inventory.get(i);
            if (item.getTypeI() == type){
                System.out.println((i+1)+") "+item.getName()+"\t x"+item.getQuantity());
            }
        }
    }
    public Item getInventory(int id){
        return inventory.get(id);
    }
    public int getInventoryQuantity(Item item){
        Item dummy = inventory.stream().
                filter(inventory -> item.getName().equalsIgnoreCase(inventory.getName())).
                findAny().orElse(null);
        if (inventory.isEmpty()){
            return 0;
        }

        if (dummy == null){
            return 0;
        } else {
            return dummy.getQuantity();
        }
    }
    public boolean alreadyHave(Item item){
        Item dummy = inventory.stream().
                filter(inventory -> item.getName().equalsIgnoreCase(inventory.getName())).
                findAny().orElse(null);
        if (dummy == null){
            return false;
        } else {
            return true;
        }
    }


    //getter skill slot
    public Skill getSlot1() {
        return slot1;
    }
    public Skill getSlot2() {
        return slot2;
    }
    public Skill getSlot3() {
        return slot3;
    }

    //setter Equipment
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

    //setter Inventory
    public void setInventory(Item item) {
        this.inventory.add(item);
    }
    public void replaceInventory(int id, Item item){
        this.inventory.remove(id);
        this.inventory.add(item);
    }
    public void removeItem(int id){
        this.inventory.get(id).removeAll();
        this.inventory.remove(id);
    }

    //setter skill slot
    public void setSlot1(Skill slot1) {
        this.slot1 = slot1;
    }
    public void setSlot2(Skill slot2) {
        this.slot2 = slot2;
    }
    public void setSlot3(Skill slot3) {
        this.slot3 = slot3;
    }
}
