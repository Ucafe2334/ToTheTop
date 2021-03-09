package ClassData;

import java.util.Random;
import java.util.Scanner;

public class Arena {
    private static int turn = 1;
    private static boolean EndGame = false;

    public static void Battle (Race Player, Race Enemy){
        Scanner Do = new Scanner(System.in);

        Player.showstatus();
        System.out.println("What Will You Do?");
        System.out.println("1. Attack 2. Guard 3. Skip Turn");
        System.out.println("Your Action : ");

        try {
            int ch = Do.nextInt();
            switch (ch){
                case 1:
                    Player.attack(Enemy);
                    break;
                case 2:
                    Player.guard();
                    break;
                case 3:
                    Player.skip();
                    break;
                default:
                    break;
            }

            EndGame = Enemy.isDead();
        }catch (Exception e){
            System.out.println("ERROR!!");
        }
    }

    public static void battleAi (Race Ai, Race Enemy){
        try {
            Random random = new Random();
            int ch = random.nextInt(3-1)+1;
            switch (ch){
                case 1:
                    Ai.attack(Enemy);
                    break;
                case 2:
                    Ai.guard();
                    break;
                case 3:
                    Ai.skip();
                    break;
                default:
                    break;
            }
            EndGame = Enemy.isDead();
        }catch (Exception e){
            System.out.println("ERROR!!");
        }
    }

    public static void NewGame (Race Player, Race Ai){
        Race CurrentTurn = Player;
        while (!EndGame){
            if (turn == 1){
                CurrentTurn = Player;
                Battle(Player, Ai);
                turn = 2;
            }else {
                CurrentTurn = Ai;
                battleAi(Ai, Player);
                turn = 1;
            }
        }

        System.out.println(CurrentTurn.getName() + " is The Winner!!!");
    }

}
