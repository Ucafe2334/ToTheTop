package Controller.Commands;

import Data.Item.DataEquipable;
import Data.DataSkill;
import Data.Item.DataUsable;
import Model.Abstract.Item;
import Model.Enum.TypeItem;
import Model.ItemType.Equipable;
import Model.ItemType.SkillScroll;
import Model.ItemType.Usable;
import Model.Player;
import Model.Skill;

public interface ShopCommand extends BasicCommand{
    DataEquipable dataEquipable = new DataEquipable();
    DataUsable dataUsable = new DataUsable();
    DataSkill dataSkillScroll = new DataSkill();

    static void shopMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Menu Toko");
            System.out.println("uang :"+target.getGold() + " coin");

            array.add("Beli");
            array.add("Jual");
            array.add("Tas");
            array.add("Status");
            BasicCommand.printMenu();

            int pil = BasicCommand.inputint();
            switch (pil){
                case 1 -> buyMenu(target);
                case 2 -> sellMenu(target);
                case 3 -> {
                    BasicCommand.tittle("Tas");
                    if (target.getInvetoryList().isEmpty()){
                        System.out.println("Kosong");
                        BasicCommand.pauseE();
                    } else {
                        BasicCommand.printMenu(target.getInvetoryList());
                        int ch = BasicCommand.inputint();
                        if (ch == 0){
                            BasicCommand.pauseE();
                        } else {
                            PlayerCommand.manageItem(target,ch-1);
                        }
                    }
                }
                case 4 -> PlayerCommand.showEquipment(target);
                default -> stop = true;
            }
        }

    }

    static void buyMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Item di Toko");

            array.add("Perlengkapan");
            array.add("Ramuan");
            array.add("Belajar Skill");
            BasicCommand.printMenu();

            int pil = BasicCommand.inputint();
            switch (pil){
                case 1 -> equipmentMenu(target);
                case 2 -> itemMenu(target);
                case 3 -> skillMenu(target);
                default -> stop = true;
            }
        }

    }

    static void skillMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Gulungan Skill");

            dataSkillScroll.getSkill(target);
            System.out.println("0> back");

            System.out.println("uang :"+target.getGold() + " coin");
            int ItemId = BasicCommand.inputint("Choose Scroll");
            if (ItemId == 0){
                stop = true;
            } else {
                Skill skill = dataSkillScroll.getSkill(ItemId);
                if (target.getGold() < skill.getCost()){
                    System.out.println("maaf uangmu tidak cukup");
                }else if (SkillCommand.learnSkill(target,skill)){
                    target.setGold(target.getGold()-skill.getCost());
                }
            }
        }
    }

    static void equipmentMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Perlengkapan");

            dataEquipable.getItem(target);
            System.out.println("0> kembali");

            System.out.println("uang :"+target.getGold() + " coin");
            int equipId = BasicCommand.inputint("Perlengkapan yang dipilih");
            if (equipId == 0){
                stop = true;
            }else {
                Equipable item = dataEquipable.getItem(equipId);

                if (target.getGold() < item.getCost()){
                    System.out.println("maaf uangmu tidak cukup");
                }else if (target.alreadyHave(item)){
                    if (!PlayerCommand.alreadyEquip(item.equipType, target)) {
                        PlayerCommand.equip(item, target);
                    }
                    target.setGold(target.getGold()-item.getCost());
                    item.addQuantity(1);
                } else {
                    target.setGold(target.getGold()-item.getCost());
                    item.addQuantity(1);
                    target.setInventory(item);
                }
            }
        }
    }

    static void itemMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Ramuan");

            dataUsable.getItem(target);
            System.out.println("0> back");

            System.out.println("uang :"+target.getGold() + " coin");
            int ItemId = BasicCommand.inputint("pilih ramuan");
            if (ItemId == 0){
                stop = true;
            } else {
                Usable item = dataUsable.getItem(ItemId);
                if (target.getGold() < item.getCost()){
                    System.out.println("maaf uangmu tidak cukup");
                }else if (target.alreadyHave(item)){
                    target.setGold(target.getGold()-item.getCost());
                    item.addQuantity(1);
                } else {
                    target.setGold(target.getGold()-item.getCost());
                    item.addQuantity(1);
                    target.setInventory(item);
                }

            }
        }
    }

    static void sellMenu(Player target){

        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Jual Barang");
            System.out.println("uang :"+target.getGold() + " coin");

            target.getInventory();
            System.out.println("0) kembali");
            int selected = BasicCommand.inputint("Pilih barang yang ingin dijual");
            selected --;
            if (selected != -1) {
                if (target.getInventory(selected) == null){
                    System.out.println("barang yang dipilih tidak ditemukan");
                }else {
                    boolean a = false;
                    while (!a) {
                        Item item = target.getInventory(selected);
                        String builder = "Berapa banyak (Maksimal :" + item.getQuantity() + ")";
                        int quantity = BasicCommand.inputint(builder);

                        if (item.getQuantity() == quantity) {
                            if (item.getTypeI() == TypeItem.EquipableItem) {
                                PlayerCommand.unequipped((Equipable) item, target);
                            }
                            target.removeItem(selected);
                            target.setGold(target.getGold() + (item.getSell() * quantity));
                            a = true;
                        } else if (item.getQuantity() < quantity) {
                            System.out.println("kamu ga punya sebanyak itu");
                        } else if (quantity > 0) {
                            item.removeSome(quantity);
                            target.replaceInventory(selected, item);
                            target.setGold(target.getGold() + (item.getSell() * quantity));
                            a = true;
                        } else {
                            System.out.println("tolong masukan angka yang benar");
                        }
                    }
                }
            } else {
                stop = true;
            }
        }

    }
}
