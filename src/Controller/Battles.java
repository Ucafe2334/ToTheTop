package Controller;

import Controller.Commands.BattleCommands;
import Model.Characters;
import Model.Player;

import java.util.Random;
import java.util.Scanner;

public class Battles {
    private static int turn = 1;
    private static boolean EndGame = false;

    public static void Battle (Characters player, Characters enemy){
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

    public static void battleAi (Characters ai, Characters enemy){
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

    public static void NewGame (Characters player, Characters Ai){
        Characters CurrentTurn = player;
        while (!EndGame){
            if (turn == 1){
                CurrentTurn = player;
                Battle(player, Ai);
                turn = 2;
            }else {
                CurrentTurn = Ai;
                battleAi(Ai, player);
                turn = 1;
            }
        }

        System.out.println(CurrentTurn.getName() + " is The Winner!!!");
    }

}
