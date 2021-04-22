import Controller.Battles;
import Controller.Commands.PlayerCommands;
import Data.DataEnemy;
import Data.DataItem;
import Data.DataPlayer;
import Data.DataWeapon;
import Model.Characters;
import Model.Enemy;
import Model.ItemType.Equipable;
import Model.Player;

import java.util.Random;
import java.util.Scanner;

public class Engine implements PlayerCommands{
    public static void main(String[] args) {
        try {
            Scanner Ch1 = new Scanner(System.in);
            Scanner Ch2 = new Scanner(System.in);
            Scanner Ch3 = new Scanner(System.in);
            Scanner Ch4 = new Scanner(System.in);
            Random random = new Random();

            DataPlayer dataPlayer = new DataPlayer();
            DataEnemy dataEnemy = new DataEnemy();
            DataWeapon dataWeapon = new DataWeapon();
            DataItem dataItem = new DataItem();

            dataPlayer.getPlayer();
            System.out.println("Select Your Race : ");
            int raceId = Ch1.nextInt();

            System.out.println("enter your name : ");
            String playerName = Ch2.nextLine();

            dataWeapon.getWeapon();
            System.out.println("Select Your Weapons");
            int weaponId = Ch3.nextInt();

            dataItem.getItem();
            System.out.println("Select Your Weapons");
            int itemId = Ch4.nextInt();

            Player player = dataPlayer.getPlayer(raceId);
            Equipable equipable = dataWeapon.getWeapon(weaponId);
            player.setName(playerName);
            PlayerCommands.equip(equipable,player);
            player.setInventory(dataItem.getItem(itemId));


            int selectedAi1 = random.nextInt(3-1) + 1;
            Enemy ai = dataEnemy.getEnemy(selectedAi1);

            Battles.NewGame(player, ai);
        }catch (Exception e){
            System.out.println("Engine ERROR!!");
        }
    }
}
