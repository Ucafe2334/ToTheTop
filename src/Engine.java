import Controller.Battles;
import Controller.Commands.BasicCommand;
import Controller.Commands.PlayerCommands;
import Controller.Commands.ShopCommand;
import Data.Characters.DataEnemy;
import Data.Item.DataUsable;
import Data.Characters.DataPlayer;
import Model.Enemy;
import Model.Player;

import java.util.Random;
import java.util.Scanner;

public class Engine implements BasicCommand,PlayerCommands{
    public static void main(String[] args) {
        try {
            Random random = new Random();

            DataPlayer dataPlayer = new DataPlayer();
            DataEnemy dataEnemy = new DataEnemy();

            dataPlayer.getChar();
            int raceId = BasicCommand.inputint("Select Race");

            String playerName = BasicCommand.inputString("enter your name");

            Player player = dataPlayer.getChar(raceId);
            player.setName(playerName);
            player.setGold(10000);
            ShopCommand.shopMenu(player);

            int selectedAi1 = random.nextInt(3-1) + 1;
            Enemy ai = dataEnemy.getEnemy(selectedAi1);

            Battles.NewGame(player, ai);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
