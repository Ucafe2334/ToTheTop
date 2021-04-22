package Controller.Commands;

import Model.Item;
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

        target.setMaxHP(target.getMaxHP()+item.getHP());
        target.setHP(target.getHP()+ item.getHP());
        target.setMaxMP(target.getMaxMP()+item.getMP());
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

        target.setMaxHP(target.getMaxHP()-item.getHP());
        target.setHP(target.getHP()-item.getHP());
        target.setMaxMP(target.getMaxMP()-item.getMP());
        target.setMP(target.getMP()-item.getMP());

        target.setPA(target.getPA()-item.getPA());
        target.setMA(target.getMA()-item.getMA());
        target.setSpeed(target.getSpeed()-item.getSpeed());
        target.setDeff(target.getDeff()-item.getDeff());
    }

    static void itemEffect(Player player, Item usable){
        System.out.println("Using Item "+usable.getName());

        if (usable.getHP() > 0){
            player.setHP(player.getHP()+usable.getHP());
            if (player.getMaxHP() < player.getHP()){
                player.setHP(player.getMaxHP());
            }
            System.out.println(player.getName()+" recovery "+usable.getHP()+"HP");
        }
        if (usable.getMP() > 0){
            player.setMP(player.getMP()+ usable.getMP());
            if (player.getMaxMP() < player.getMP()){
                player.setMP(player.getMaxMP());
            }
            System.out.println(player.getName()+ " recovery "+usable.getMP()+"MP");
        }
    }
}
