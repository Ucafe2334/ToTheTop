package Controller.Commands;

import Model.Enum.TypeEquip;
import Model.Abstract.Item;
import Model.ItemType.Equipable;
import Model.Player;

public interface PlayerCommand extends BasicCommand{

    static void equip(Equipable item, Player target){
        TypeEquip type = item.equipType;

        if (type == TypeEquip.WEAPONS){
            target.setWeapons(item);
        } else if (type == TypeEquip.ARMOUR){
            target.setArmor(item);
        }else if (type == TypeEquip.ACCESSORIES){
            target.setAccessories(item);
        }else if (type == TypeEquip.SECONDARY_WEAPONS){
            target.setSecondaryWeapons(item);
        } else {
            System.out.println("not equipped");
        }

        target.setMaxHP(target.getMaxHP()+item.getHP());
        target.setHP(target.getHP()+ item.getHP());
        target.setMaxMP(target.getMaxMP()+item.getMP());
        target.setMP(target.getMP()+item.getMP());

        target.setPA(target.getPA()+item.getPA());
        target.setMA(target.getMA()+item.getMA());
        target.setSpeed(target.getSpeed()+item.getSpeed());
        target.setDef(target.getDef()+item.getDef());
    }

    static void unequipped(Equipable item, Player target){
        TypeEquip type = item.equipType;

        if (type == TypeEquip.WEAPONS){
            target.setWeapons(new Equipable());
        } else if (type == TypeEquip.ARMOUR){
            target.setArmor(new Equipable());
        }else if (type == TypeEquip.ACCESSORIES){
            target.setAccessories(new Equipable());
        }else if (type == TypeEquip.SECONDARY_WEAPONS){
            target.setSecondaryWeapons(new Equipable());
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
        target.setDef(target.getDef()-item.getDef());
    }

    static void usingItem(Player player, Item usable){
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

    static boolean alreadyEquip(Equipable item,Player target){
        TypeEquip type = item.equipType;

        if (type == TypeEquip.WEAPONS && target.getWeapons().getId() != 0){
            return true;
        } else if (type == TypeEquip.ARMOUR && target.getArmor().getId() != 0){
            return true;
        }else if (type == TypeEquip.ACCESSORIES && target.getAccessories().getId() != 0){
            return true;
        }else return type == TypeEquip.SECONDARY_WEAPONS && target.getSecondaryWeapons().getId() != 0;
    }

    static void showStatus(Player target){
        BasicCommand.tittle("Player Status");

        System.out.println("Name\t: " + target.getName());
        System.out.println("HP\t: " + target.getHP() + "/" + target.getMaxHP());
        System.out.println("MP\t: " + target.getMP() + "/" + target.getMaxMP());
        System.out.println("PA/MA/DEF/SPD");
        System.out.println(target.getPA() + "/" + target.getMA() + "/" + target.getDef() + "/" + target.getSpeed());

        BasicCommand.pauseE();
    }

    static void showEquipment(Player target){
        showStatus(target);
        BasicCommand.tittle("Equipment");

        System.out.println("Main Weapons : "+target.getWeapons().getName());
        System.out.println("Secondary Weapon : "+target.getSecondaryWeapons().getName());
        System.out.println("Armor : "+target.getArmor().getName());
        System.out.println("Accesories : "+target.getAccessories().getName());

        BasicCommand.pause();
    }
}
