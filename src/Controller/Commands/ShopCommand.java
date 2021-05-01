package Controller.Commands;

import Data.Item.DataEquipable;
import Data.Item.DataUsable;
import Model.Abstract.Item;
import Model.Enum.TypeItem;
import Model.ItemType.Equipable;
import Model.ItemType.Usable;
import Model.Player;

public interface ShopCommand extends BasicCommand{
    DataEquipable dataEquipable = new DataEquipable();
    DataUsable dataUsable = new DataUsable();

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
                    target.getInventory();
                    BasicCommand.pause();
                }
                case 5 -> PlayerCommands.showEquipment(target);
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
            BasicCommand.printMenu();

            int pil = BasicCommand.inputint();
            switch (pil){
                case 1 -> equipmentMenu(target);
                case 2 -> itemMenu(target);
                default -> stop = true;
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

                if (!PlayerCommands.alreadyEquip(item, target)) {
                    PlayerCommands.equip(item, target);
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
            selected -=1;
            if (selected !=-1){
                boolean a = false;
                while (!a){
                    Item item = target.getInventory(selected);
                    String builder = "How Much (max :"+item.getQuantity()+")";
                    int quantity = BasicCommand.inputint(builder);

                    if (item.getQuantity() == quantity){
                        if (item.getTypeI() == TypeItem.EquipableItem){
                            PlayerCommands.unequipped((Equipable) item,target);
                        }
                        target.removeItem(selected);
                        target.setGold(target.getGold()+(item.getSell()*quantity));
                        a = true;
                    } else if(item.getQuantity() < quantity){
                        System.out.println("you don't even have that much");
                    } else if(quantity > 0) {
                        item.removeSome(quantity);
                        target.replaceInventory(selected,item);
                        target.setGold(target.getGold()+(item.getSell()*quantity));
                        a = true;
                    } else {
                        System.out.println("please input the right number");
                    }
                }
            } else {
                stop = true;
            }
        }

    }
}
