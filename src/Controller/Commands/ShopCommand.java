package Controller.Commands;

import Data.Item.DataEquipable;
import Data.Item.DataUsable;
import Model.Enum.TypeItem;
import Model.Item;
import Model.ItemType.Equipable;
import Model.ItemType.Usable;
import Model.Player;

import java.util.Scanner;

public interface ShopCommand {
    static void shopMenu(Player target){
        boolean stop = false;
        while (!stop){
            System.out.println("========================================\n");
            System.out.println("your gold :"+target.getGold());
            int pil;
            Scanner scPil = new Scanner(System.in);
            System.out.println("Shop\n" +
                    "1. Buy\n" +
                    "2. Sell\n" +
                    "3. Enchant (under construction)\n"+
                    "4. Player Item\n"+
                    "5. Player Equipment\n"+
                    "0. Exit\n" +
                    "Pilihan :");
            pil = scPil.nextInt();
            switch (pil){
                case 1 -> buyMenu(target);
                case 2 -> sellMenu(target);
                case 4 -> {
                    System.out.println("========================================\n");
                    target.getInventory();
                    System.out.println("========================================\n");
                }
                case 5 -> PlayerCommands.showEquipment(target);
                default -> stop = true;
            }
        }

    }

    static void buyMenu(Player target){
        boolean stop = false;
        while (!stop){
            System.out.println("========================================\n");
            System.out.println("your gold :"+target.getGold());
            int pil;
            Scanner scPil = new Scanner(System.in);
            System.out.println("Shop\n" +
                    "1. Equipment\n" +
                    "2. Item\n" +
                    "0. Back\n" +
                    "Pilihan :");
            pil = scPil.nextInt();
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
            System.out.println("========================================\n");
            System.out.println("your gold :"+target.getGold());

            DataEquipable dataEquipable = new DataEquipable();
            Scanner scPil = new Scanner(System.in);

            dataEquipable.getItem();
            System.out.println("0> back");

            System.out.println("Select Your Weapons :");
            int equipId = scPil.nextInt();
            if (equipId == 0){
                stop = true;
            } else {
                Equipable item = dataEquipable.getItem(equipId);
                target.setGold(target.getGold()-item.getCost());
                if (PlayerCommands.alreadyEquip(item,target)){
                    target.setInventory(item);
                } else {
                    PlayerCommands.equip(item,target);
                    target.setInventory(item);
                }

            }
        }
    }

    static void itemMenu(Player target){
        boolean stop = false;
        while (!stop){
            System.out.println("========================================\n");
            System.out.println("your gold :"+target.getGold());

            DataUsable dataUsable = new DataUsable();
            Scanner scPil = new Scanner(System.in);

            dataUsable.getItem();
            System.out.println("0> back");

            System.out.println("Select Your Weapons :");
            int ItemId = scPil.nextInt();
            if (ItemId == 0){
                stop = true;
            } else {
                Usable item = dataUsable.getItem(ItemId);
                target.setGold(target.getGold()-item.getCost());
                target.setInventory(item);
            }
        }
    }

    static void sellMenu(Player target){

        boolean stop = false;
        while (!stop){
            System.out.println("========================================\n");
            System.out.println("your gold :"+target.getGold());
            target.getInventory();
            System.out.println("-1) back");
            Scanner scItem = new Scanner(System.in);
            int selected = scItem.nextInt();
            if (selected !=-1){
                Item item = target.getInventory(selected);
                System.out.println(item.getTypeI());
                PlayerCommands.unequip((Equipable) item,target);
                target.removeItem(selected);
                target.setGold(target.getGold()+item.getCost());
            } else {
                stop = true;
            }
        }

    }
}
