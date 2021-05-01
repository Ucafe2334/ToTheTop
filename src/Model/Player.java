package Model;

import Model.Abstract.Characters;
import Model.Abstract.Item;
import Model.Enum.TypeItem;
import Model.ItemType.Equipable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player extends Characters{
    //equiped
    private Equipable weapons;              //weapon yang di equip
    private Equipable secondaryWeapons;     //weapon ke 2 yang di equip
    private Equipable armor;                //armor yang di equip
    private Equipable accessories;          //accessories yang di equip

    //skill slot
    private Skill slot1;                    //slot skill 1
    private Skill slot2;                    //slot skill 2
    private Skill slot3;                    //slot skill 3

    //inventory
    private final ArrayList<Item> inventory;

    //constructor
    public Player(String playerName, String desc, int hp, int mp, int pa, int ma, int def, int spd) {
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
        this.def = def;
        this.speed = spd;
        this.inventory = new ArrayList<>();
    }

    //getter
    public Equipable getSecondaryWeapons() {
        try {
            return secondaryWeapons;
        }catch (Exception e){
            return null;
        }
    }
    public Equipable getWeapons() {
        try {
            return weapons;
        }catch (Exception e){
            return null;
        }
    }
    public Equipable getArmor() {
        try {
            return armor;
        }catch (Exception e){
            return null;
        }
    }
    public Equipable getAccessories() {
        try {
            return accessories;
        }catch (Exception e){
            return null;
        }
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
        try {
            return inventory.get(id);
        } catch (Exception e){
            return null;
        }
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
        return dummy != null;
    }


    //getter skill slot
    public Skill getSlot1() {
        try {
            return slot1;
        }catch (Exception e){
            return null;
        }

    }
    public Skill getSlot2() {
        try {
            return slot2;
        }catch (Exception e){
            return null;
        }
    }
    public Skill getSlot3() {
        try {
            return slot3;
        }catch (Exception e){
            return null;
        }
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
        inventory.sort(Item::compareTo);
    }
    public void replaceInventory(int id, Item item){
        this.inventory.remove(id);
        this.inventory.add(item);
    }
    public void removeItem(int id){
        this.inventory.get(id).removeAll();
        this.inventory.remove(id);
        inventory.sort(Item::compareTo);
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
