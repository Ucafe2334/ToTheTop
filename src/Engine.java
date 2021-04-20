import Controller.Battles;
import Data.DataEnemy;
import Data.DataPlayer;
import Model.Characters;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static void main(String[] args) {
        try {
            Scanner Ch1 = new Scanner(System.in);
            Scanner Ch2 = new Scanner(System.in);
            Random random = new Random();

            DataPlayer dataPlayer = new DataPlayer();
            DataEnemy dataEnemy = new DataEnemy();

            dataPlayer.getPlayer();
            System.out.println("Select Your Race : ");
            int raceId = Ch1.nextInt();
            System.out.println("enter your name : ");

            String playerName = Ch2.nextLine();
            Characters player = dataPlayer.getPlayer(raceId);
            player.setName(playerName);


            int selectedAi1 = random.nextInt(3-1) + 1;
            Characters ai = dataEnemy.getEnemy(selectedAi1);

            Battles.NewGame(player, ai);
        }catch (Exception e){
            System.out.println("ERROR!!");
        }
    }
}
