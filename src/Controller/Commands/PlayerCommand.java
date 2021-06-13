package Controller.Commands;

import Model.Abstract.Item;
import Model.Enum.TypeEquip;
import Model.Enum.TypeItem;
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
            System.out.println("tidak dipakai");
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
            target.setWeapons(null);
        } else if (type == TypeEquip.ARMOUR){
            target.setArmor(null);
        }else if (type == TypeEquip.ACCESSORIES){
            target.setAccessories(null);
        }else if (type == TypeEquip.SECONDARY_WEAPONS){
            target.setSecondaryWeapons(null);
        } else {
            System.out.println("masih tetap dipakai");
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

    static void unequipped(TypeEquip type, Player target){
        Equipable item;
        if (type == TypeEquip.WEAPONS){
            item = target.getWeapons();
            target.setWeapons(null);
        } else if (type == TypeEquip.ARMOUR){
            item = target.getArmor();
            target.setArmor(null);
        }else if (type == TypeEquip.ACCESSORIES){
            item = target.getAccessories();
            target.setAccessories(null);
        }else if (type == TypeEquip.SECONDARY_WEAPONS){
            item = target.getSecondaryWeapons();
            target.setSecondaryWeapons(null);
        } else {
            item = new Equipable("","",0,0,0,0,0,0,null,0);
            System.out.println("masih tetap dipakai");
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
        System.out.println("menggunakan item "+usable);

        if (usable.getHP() > 0){
            player.setHP(player.getHP()+usable.getHP());
            if (player.getMaxHP() < player.getHP()){
                player.setHP(player.getMaxHP());
            }
            System.out.println(player+" memulihkan "+usable.getHP()+"HP");
        }
        if (usable.getMP() > 0){
            player.setMP(player.getMP()+ usable.getMP());
            if (player.getMaxMP() < player.getMP()){
                player.setMP(player.getMaxMP());
            }
            System.out.println(player+ " memulihkan "+usable.getMP()+"MP");
        }
    }

    static boolean alreadyEquip(Equipable item,Player target){
        TypeEquip type = item.equipType;
        String name = item.toString();
        if (type == TypeEquip.WEAPONS && target.getWeapons()== item){
            return true;
        } else if (type == TypeEquip.ARMOUR && target.getArmor()== item){
            return true;
        }else if (type == TypeEquip.ACCESSORIES && target.getAccessories()== item){
            return true;
        }else return type == TypeEquip.SECONDARY_WEAPONS && target.getSecondaryWeapons()== item;
    }

    static boolean alreadyEquip(TypeEquip type, Player target){
        if (type == TypeEquip.WEAPONS && target.getWeapons()!= null){
            return true;
        } else if (type == TypeEquip.ARMOUR && target.getArmor()!= null){
            return true;
        }else if (type == TypeEquip.ACCESSORIES && target.getAccessories()!= null){
            return true;
        }else return type == TypeEquip.SECONDARY_WEAPONS && target.getSecondaryWeapons()!= null;
    }

    static void showStatus(Player target){
        BasicCommand.tittle("Status Player");

        System.out.println("nama\t: " + target);
        System.out.println("HP\t: " + target.getHP() + "/" + target.getMaxHP());
        System.out.println("MP\t: " + target.getMP() + "/" + target.getMaxMP());
        System.out.println("PA/MA/DEF/SPD");
        System.out.println(target.getPA() + "/" + target.getMA() + "/" + target.getDef() + "/" + target.getSpeed());

        BasicCommand.pauseE();
    }

    static void showEquipment(Player target){
        showStatus(target);
        showSkill(target);
        BasicCommand.tittle("Perlengkapan");

        System.out.println("Senjata Utama : "+target.getWeapons());
        System.out.println("Senjata Cadangan : "+target.getSecondaryWeapons());
        System.out.println("Pelindung Tubuh : "+target.getArmor());
        System.out.println("Asesoris : "+target.getAccessories());

        BasicCommand.pause();
    }

    static void showSkill(Player player){
        BasicCommand.tittle("Skill");
        System.out.println("slot 1 :"+player.getSlot1());
        System.out.println("slot 2 :"+player.getSlot2());
        System.out.println("slot 3 :"+player.getSlot3());
        BasicCommand.pause();
    }

    static void manageItem(Player target, int id){
        Item item = target.getInventory(id);
        BasicCommand.tittle(item.toString());
        if (item.getTypeI() == TypeItem.EquipableItem){
            System.out.println("HP/MP/PA/MA/DEF/SPD");
            System.out.println(item.getHP()+"/"+item.getMP()+"/"+item.getPA() + "/" + item.getMA() + "/" + item.getDef() + "/" + item.getSpeed());
        }
        System.out.println(item.getDesc()+"\n");
        array.add("buang semua");
        if (item.getTypeI() == TypeItem.EquipableItem){
            if (alreadyEquip((Equipable) item,target)){
                array.add("tanggalkan perlengkapan");
            }else {
                array.add("pakai perlengkapan");
            }
        } else if (item.getTypeI() == TypeItem.UsableItem){
            array.add("gunakan");
        }
        BasicCommand.printMenu();
        int sel = BasicCommand.inputint("pilih salah satu");
        if (sel == 1){
            if (alreadyEquip((Equipable) item,target)) {
                unequipped((Equipable) item, target);
                BasicCommand.subtittle("menanggalkan perlengkapan");
            }
            target.removeItem(id);
        } else if (sel == 2){
            if (item.getTypeI() == TypeItem.EquipableItem){
                if (alreadyEquip((Equipable) item,target)){
                    unequipped((Equipable) item,target);
                    BasicCommand.subtittle("menanggalkan perlengkapan");
                } else {
                    if (alreadyEquip(((Equipable) item).equipType,target)){
                        unequipped(((Equipable) item).equipType,target);
                        BasicCommand.subtittle("menanggalkan perlangkapan");
                    }
                    equip((Equipable) item, target);
                    BasicCommand.subtittle("memakai perlengkapan");
                }
            } else if (item.getTypeI() == TypeItem.UsableItem){
                usingItem(target,item);
                if (item.getQuantity() > 1){
                    item.removeSome(1);
                    target.replaceInventory(id,item);
                } else {
                    target.removeItem(id);
                }

            }
        }
    }
}
