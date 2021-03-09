import ClassData.Arena;
import ClassData.Race;
import ClassData.Weapon;
import Data.DataRace;
import Data.DataWeapon;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static void main(String[] args) {
        try {
            Scanner Ch1 = new Scanner(System.in);
            Scanner Ch2 = new Scanner(System.in);
            Random random = new Random();

            DataRace race = new DataRace();
            DataWeapon weapon = new DataWeapon();

            race.getRace();
            System.out.print("Select Your Race : ");
            int playerId = Ch1.nextInt();
            Race Player = race.getRace(playerId);

            weapon.getWeapon();
            System.out.print("Select Your Weapon : ");
            int weaponId = Ch2.nextInt();
            System.out.println(weaponId);
            Weapon PlayerWeapon = weapon.getWeapon(weaponId);
            Player.setWeapon(PlayerWeapon);

            int SelectedAi1 = random.nextInt(3-1) + 1;
            Race Ai = race.getRace(SelectedAi1);
            int SelectedAi2 = random.nextInt(3-1) + 1;
            Weapon AiWeapon = weapon.getWeapon(SelectedAi2);
            Ai.setWeapon(AiWeapon);

            Arena.NewGame(Player, Ai);
        }catch (Exception e){
            System.out.println("ERROR!!");
        }
    }
}
