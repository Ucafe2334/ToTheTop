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
            BasicCommand.tittle("Shop Menu");
            System.out.println("your gold :"+target.getGold());

            array.add("Buy");
            array.add("Sell");
            array.add("Enchant (under construction)");
            array.add("Player Item");
            array.add("Player Equipment");
            BasicCommand.printMenu();

            int pil = BasicCommand.inputint();
            switch (pil){
                case 1 -> buyMenu(target);
                case 2 -> sellMenu(target);
                case 4 -> {
                    BasicCommand.tittle("Your Inventory");
                    if (target.getInvetoryList().isEmpty()){
                        System.out.println("Empty");
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
                case 5 -> PlayerCommand.showEquipment(target);
                default -> stop = true;
            }
        }

    }

    static void buyMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Buying Menu");
            System.out.println("your gold :"+target.getGold());

            array.add("Equipment");
            array.add("Item");
            array.add("Learn Skill");
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
            BasicCommand.tittle("Skill Scroll Shop");
            System.out.println("your gold :"+target.getGold());

            dataSkillScroll.getSkill(target);
            System.out.println("0> back");

            int ItemId = BasicCommand.inputint("Choose Scroll");
            if (ItemId == 0){
                stop = true;
            } else {
                Skill skill = dataSkillScroll.getSkill(ItemId);
                if (SkillCommand.learnSkill(target,skill)){
                    target.setGold(target.getGold()-skill.getCost());
                }
            }
        }
    }

    static void equipmentMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Equipment Shop");
            System.out.println("your gold :"+target.getGold());

            dataEquipable.getItem(target);
            System.out.println("0> back");

            int equipId = BasicCommand.inputint("Choose Equipment");
            if (equipId == 0){
                stop = true;
            } else {
                Equipable item = dataEquipable.getItem(equipId);
                target.setGold(target.getGold()-item.getCost());

                if (!PlayerCommand.alreadyEquip(item.equipType, target)) {
                    System.out.println(PlayerCommand.alreadyEquip(item, target));
                    PlayerCommand.equip(item, target);
                }
                if (target.alreadyHave(item)){
                    item.addQuantity(1);
                } else {
                    item.addQuantity(1);
                    target.setInventory(item);
                }
            }
        }
    }

    static void itemMenu(Player target){
        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Item Shop");
            System.out.println("your gold :"+target.getGold());

            dataUsable.getItem(target);
            System.out.println("0> back");

            int ItemId = BasicCommand.inputint("Choose Item");
            if (ItemId == 0){
                stop = true;
            } else {
                Usable item = dataUsable.getItem(ItemId);
                target.setGold(target.getGold()-item.getCost());
                if (target.alreadyHave(item)){
                    item.addQuantity(1);
                } else {
                    item.addQuantity(1);
                    target.setInventory(item);
                }
            }
        }
    }

    static void sellMenu(Player target){

        boolean stop = false;
        while (!stop){
            BasicCommand.tittle("Sell Menu");
            System.out.println("your gold :"+target.getGold());

            target.getInventory();
            System.out.println("0) back");
            int selected = BasicCommand.inputint("Choose Item");
            selected --;
            if (selected != -1) {
                if (target.getInventory(selected) == null){
                    System.out.println("There is no item who have that id");
                }else {
                    boolean a = false;
                    while (!a) {
                        Item item = target.getInventory(selected);
                        String builder = "How Much (max :" + item.getQuantity() + ")";
                        int quantity = BasicCommand.inputint(builder);

                        if (item.getQuantity() == quantity) {
                            if (item.getTypeI() == TypeItem.EquipableItem) {
                                PlayerCommand.unequipped((Equipable) item, target);
                            }
                            target.removeItem(selected);
                            target.setGold(target.getGold() + (item.getSell() * quantity));
                            a = true;
                        } else if (item.getQuantity() < quantity) {
                            System.out.println("you don't even have that much");
                        } else if (quantity > 0) {
                            item.removeSome(quantity);
                            target.replaceInventory(selected, item);
                            target.setGold(target.getGold() + (item.getSell() * quantity));
                            a = true;
                        } else {
                            System.out.println("please input the right number");
                        }
                    }
                }
            } else {
                stop = true;
            }
        }

    }
}
