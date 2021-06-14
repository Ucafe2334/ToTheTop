package Data.Item;

import Data.DataItem;
import Model.Abstract.Item;
import Model.Enum.TypeEquip;
import Model.ItemType.Equipable;
import Model.Player;

import java.util.Map;

public class DataEquipable extends DataItem {
    public DataEquipable(){
        //Weapon
        this.DataItem.put(1, new Equipable("Willow Compound Bow",
                "",
                0,0,38,20,0,44, TypeEquip.WEAPONS,63));
        this.DataItem.put(2, new Equipable("Dragonborn Crossbow",
                "",
                0,0,90,300,0,52, TypeEquip.WEAPONS,104));
        this.DataItem.put(3, new Equipable("Warped Scepter",
                "",
                0,0,12,20,0,15, TypeEquip.WEAPONS,63));
        this.DataItem.put(4, new Equipable("Spectralwoof Pole",
                "",
                0,0,40,400,0,13, TypeEquip.WEAPONS,101));
        this.DataItem.put(5, new Equipable("Spellbinder",
                "",
                0,0,20,46,0,12, TypeEquip.WEAPONS,67));
        this.DataItem.put(6, new Equipable("Arcane Battletome",
                "",
                0,0,24,720,0,28, TypeEquip.WEAPONS,103));
        this.DataItem.put(7, new Equipable("Yew Crossfire",
                "",
                0,0,42,20,0,40, TypeEquip.WEAPONS,66));
        this.DataItem.put(8, new Equipable("Precise Speargun",
                "",
                0,0,96,400,0,48, TypeEquip.WEAPONS,102));
        this.DataItem.put(9, new Equipable("Spiteblade (Sword)",
                "",
                0,0,52,20,0,34, TypeEquip.WEAPONS,63));
        this.DataItem.put(10, new Equipable("Soulsrapier",
                "",
                0,0,96,68,0,78, TypeEquip.WEAPONS,101));

        //secondary weapon
        this.DataItem.put(11, new Equipable("Vengeance Dagger",
                "",
                0,0,42,36,0,44, TypeEquip.SECONDARY_WEAPONS,61));
        this.DataItem.put(12, new Equipable("Ragespike",
                "",
                0,0,68,60,0,84, TypeEquip.SECONDARY_WEAPONS,102));
        this.DataItem.put(13, new Equipable("Doom fist",
                "",
                0,0,30,36,0,38, TypeEquip.SECONDARY_WEAPONS,60));
        this.DataItem.put(14, new Equipable("Bloodfist knuckler",
                "",
                0,0,56,60,0,80, TypeEquip.SECONDARY_WEAPONS,100));
        this.DataItem.put(15, new Equipable("Void Throwblade",
                "",
                0,0,44,18,0,50, TypeEquip.SECONDARY_WEAPONS,69));
        this.DataItem.put(16, new Equipable("Blindside Throwing Knife",
                "",
                0,0,48,34,0,94, TypeEquip.SECONDARY_WEAPONS,105));

        //armour
        this.DataItem.put(17, new Equipable("Guardian Chainmail",
                "",
                0,0,0,0,50,-50, TypeEquip.ARMOUR,142));
        this.DataItem.put(18, new Equipable("Arcane Vest",
                "",
                0,0,0,0,176,-100, TypeEquip.ARMOUR,450));
        this.DataItem.put(19, new Equipable("Iron Breastplate",
                "",
                0,0,0,0,56,-100, TypeEquip.ARMOUR,174));
        this.DataItem.put(20, new Equipable("Warlord Breastplate",
                "",
                0,0,0,0,82,-150, TypeEquip.ARMOUR,480));
        this.DataItem.put(21, new Equipable("Heavy Iron Armor",
                "",
                0,0,0,0,65,-150, TypeEquip.ARMOUR,185));
        this.DataItem.put(22, new Equipable("Honed Garments of Infinty",
                "",
                0,0,0,0,91,-150, TypeEquip.ARMOUR,500));
        }

    @Override
    public void getItem(Player target) {
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();

            System.out.println(id + "> " + idItem+"\tx"+target.getInventoryQuantity(idItem));
            System.out.println("price : "+idItem.getCost());
            System.out.println("HP/MP/PA/MA/DEF/SPD");
            System.out.println(idItem.getHP()+"/"+idItem.getMP()+"/"+idItem.getPA() + "/" + idItem.getMA() + "/" + idItem.getDef() + "/" + idItem.getSpeed()+"\n");
        }
    }

    public void getItem(Player target, TypeEquip type) {
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();
            Equipable item = (Equipable) idItem;

            if (item.getEquipType() == type){
                System.out.println(id + "> " + idItem+"\tx"+target.getInventoryQuantity(idItem));
                System.out.println("price : "+idItem.getCost());
                System.out.println("HP/MP/PA/MA/DEF/SPD");
                System.out.println(idItem.getHP()+"/"+idItem.getMP()+"/"+idItem.getPA() + "/" + idItem.getMA() + "/" + idItem.getDef() + "/" + idItem.getSpeed()+"\n");

            }
        }
    }

    @Override
    public Equipable getItem(int id) {
        return (Equipable) DataItem.get(id);
    }
}
