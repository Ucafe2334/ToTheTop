package Controller.Commands;

import Model.ItemType.Equipable;
import Model.Player;

public interface PlayerCommands {
    static void equip(Equipable item, Player target){
        Equipable.typeE type = item.equipType;

        if (type == Equipable.typeE.WEAPONS){
            target.setWeapons(item);
        } else if (type == Equipable.typeE.ARMOUR){
            target.setArmor(item);
        }else if (type == Equipable.typeE.ACCESSORIES){
            target.setAccessories(item);
        }else if (type == Equipable.typeE.SECONDARY_WEAPONS){
            target.setSecondaryWeapons(item);
        } else {
            return;
        }

        target.setMaxHP(target.getMaxHP()+item.getMaxHP());
        target.setHP(target.getHP()+ item.getHP());
        target.setMaxMP(target.getMaxMP()+item.getMaxMP());
        target.setMP(target.getMP()+item.getMP());

        target.setPA(target.getPA()+item.getPA());
        target.setMA(target.getMA()+item.getMA());
        target.setSpeed(target.getSpeed()+item.getSpeed());
        target.setDeff(target.getDeff()+item.getDeff());
    }

    static void unequip(Equipable item, Player target){
        Equipable.typeE type = item.equipType;

        if (type == Equipable.typeE.WEAPONS){
            target.setWeapons(null);
        } else if (type == Equipable.typeE.ARMOUR){
            target.setArmor(null);
        }else if (type == Equipable.typeE.ACCESSORIES){
            target.setAccessories(null);
        }else if (type == Equipable.typeE.SECONDARY_WEAPONS){
            target.setSecondaryWeapons(null);
        } else {
            return;
        }

        target.setMaxHP(target.getMaxHP()-item.getMaxHP());
        target.setHP(target.getHP()-item.getHP());
        target.setMaxMP(target.getMaxMP()-item.getMaxMP());
        target.setMP(target.getMP()-item.getMP());

        target.setPA(target.getPA()-item.getPA());
        target.setMA(target.getMA()-item.getMA());
        target.setSpeed(target.getSpeed()-item.getSpeed());
        target.setDeff(target.getDeff()-item.getDeff());
    }
}
