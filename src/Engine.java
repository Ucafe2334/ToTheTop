import Controller.Battles;
import Controller.Commands.PlayerCommands;
import Controller.Commands.ShopCommand;
import Data.Characters.DataEnemy;
import Data.Item.DataUsable;
import Data.Characters.DataPlayer;
import Model.Enemy;
import Model.Player;

import java.util.Random;
import java.util.Scanner;

public class Engine implements PlayerCommands{
    public static void main(String[] args) {
        try {
            Scanner Ch1 = new Scanner(System.in);
            Scanner Ch2 = new Scanner(System.in);
            Random random = new Random();

            DataPlayer dataPlayer = new DataPlayer();
            DataEnemy dataEnemy = new DataEnemy();

            DataUsable dataUsable = new DataUsable();

            dataPlayer.getChar();
            System.out.println("Select Your Race : ");
            int raceId = Ch1.nextInt();

            System.out.println("enter your name : ");
            String playerName = Ch2.nextLine();

            Player player = dataPlayer.getChar(raceId);
            player.setName(playerName);
            player.setGold(10000);
            ShopCommand.shopMenu(player);

            int selectedAi1 = random.nextInt(3-1) + 1;
            Enemy ai = dataEnemy.getEnemy(selectedAi1);

            Battles.NewGame(player, ai);
        }catch (Exception e){
            System.out.println("Engine ERROR!!");
        }
    }
}
