package GameSystem;

import GameSystem.Commands.BattleCommands;

import java.util.Random;
import java.util.Scanner;

public class Battles {
    private static int turn = 1;
    private static boolean EndGame = false;

    public static void Battle (Player player, Player enemy){
        Scanner Do = new Scanner(System.in);
        BattleCommands bc = new BattleCommands();

        bc.showstatus(player);
        System.out.println("What Will You Do?");
        System.out.println("1. Attack 2. Guard 3. Skip Turn");
        System.out.println("Your Action : ");

        try {
            int ch = Do.nextInt();
            switch (ch){
                case 1:
                    bc.attack(player, enemy);
                    break;
                case 2:
                    bc.guard(player);
                    break;
                case 3:
                    bc.skip(player);
                    break;
                default:
                    break;
            }

            EndGame = enemy.isDead();
        }catch (Exception e){
            System.out.println("ERROR!!");
        }
    }

    public static void battleAi (Player ai, Player enemy){
        try {
            Random random = new Random();
            BattleCommands bc = new BattleCommands();

            int ch = random.nextInt(3-1)+1;
            switch (ch){
                case 1:
                    bc.attack(ai, enemy);
                    break;
                case 2:
                    bc.guard(ai);
                    break;
                case 3:
                    bc.skip(ai);
                    break;
                default:
                    break;
            }
            EndGame = enemy.isDead();
        }catch (Exception e){
            System.out.println("ERROR!!");
        }
    }

    public static void NewGame (Player Player, Player Ai){
        Player CurrentTurn = Player;
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

        System.out.println(CurrentTurn.getPlayerName() + " is The Winner!!!");
    }

}
