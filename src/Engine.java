import Controller.Battles;
import Data.DataPlayer;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static void main(String[] args) {
        try {
            Scanner Ch1 = new Scanner(System.in);
            Scanner Ch2 = new Scanner(System.in);
            Random random = new Random();

            DataPlayer race = new DataPlayer();

            race.getPlayer();
            System.out.println("Select Your Race : ");
            int raceId = Ch1.nextInt();
            System.out.println("enter your name : ");
            String playerName = Ch2.nextLine();
            Race playerrace = race.getPlayer(raceId);
            //Player player = new Player(playerName,playerrace);


            int SelectedAi1 = random.nextInt(3-1) + 1;
            Race aiRace = race.getPlayer(SelectedAi1);
            //Player Ai = new Player("Computer 1",aiRace);

            Battles.NewGame(player, Ai);
        }catch (Exception e){
            System.out.println("ERROR!!");
        }
    }
}
