package Controller;

import Controller.Commands.BattleCommand;
import Model.Characters;
import Model.Enemy;
import Model.Player;

import java.util.Random;
import java.util.Scanner;

public class Battles implements BattleCommand{
    private static int turn = 1;
    private static boolean EndGame = false;

    public static void Battle (Player player, Enemy enemy){
        Scanner Do = new Scanner(System.in);

        BattleCommand.showstatus(player);
        System.out.println("What Will You Do?");
        System.out.println("1. Attack 2. Guard 3. UseItem 4.Skip Turn");
        System.out.println("Your Action : ");

        try {
            int ch = Do.nextInt();
            switch (ch){
                case 1-> BattleCommand.attack(player, enemy);
                case 2-> BattleCommand.guard(player);
                case 3-> BattleCommand.useItem(player);
                case 4-> BattleCommand.skip(player);
                default-> System.out.println("error");
            }

            EndGame = enemy.isDead();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void battleAi (Enemy ai, Player target){
        try {
            Random random = new Random();

            int ch = random.nextInt(3-1)+1;
            switch (ch){
                case 1-> BattleCommand.attack(ai, target);
                case 2-> BattleCommand.guard(ai);
                case 3-> BattleCommand.skip(ai);
                default-> System.out.println("error");
            }
            EndGame = target.isDead();
        }catch (Exception e){
            System.out.println("Battle ERROR!!");
        }
    }

    public static void NewGame (Player player, Enemy Ai){
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
