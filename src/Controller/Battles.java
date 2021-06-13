package Controller;

import Controller.Commands.BasicCommand;
import Controller.Commands.BattleCommand;
import Controller.Commands.SkillCommand;
import Model.Abstract.Characters;
import Model.Enemy;
import Model.Enum.TypeAttribute;
import Model.Player;

import java.util.Random;

public class Battles implements BasicCommand {
    private static int turn = 1;
    private static boolean EndGame = false;

    public static void Battle (Player player, Enemy enemy){
        BattleCommand.showstatus(player);
        System.out.println("Apa yang ingin kamu lakukan?");
        System.out.println("1. Serang 2. Bertahan 3. gunakan Item 4.Skill 5.lewati giliran");

        try {
            int ch = BasicCommand.inputint();
            switch (ch){
                case 1-> BattleCommand.attack(player, enemy);
                case 2-> BattleCommand.guard(player);
                case 3-> BattleCommand.useItem(player);
                case 4-> BattleCommand.useSkill(player,enemy);
                case 5 -> BattleCommand.skip(player);
                default-> System.out.println("aksi tidak diketahui, giliran dilewati");
            }

            EndGame = enemy.isDead();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void battleAi (Enemy ai, Player target){
        try {
            BattleCommand.showstatus(ai);
            Random random = new Random();
            int ch;
            if (ai.getHP() > (int) (ai.getMaxHP()*0.5)){
                if (ai.getSkill().getAttribute() == TypeAttribute.physical){
                    ch = 2;
                }else if (ai.getSkill().getManaCost() < ai.getMP()){
                    ch = random.nextInt(2-1)+1;
                }else {
                    ch = 1;
                }
            }else if (ai.getHP() < (int)(ai.getMaxHP()*0.5)){
                ch = random.nextInt(3-1)+1;
            } else {
                ch = 3;
            }

            switch (ch){
                case 1-> BattleCommand.attack(ai, target);
                case 2-> SkillCommand.skillUse(ai,target,ai.getSkill());
                case 3-> BattleCommand.guard(ai);
                case 4-> BattleCommand.skip(ai);
                default-> System.out.println("aksi dilewati, giliran dilewati");
            }
            EndGame = target.isDead();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Boolean NewGame (Player player, Enemy Ai){
        Characters CurrentTurn = player;
        while (!EndGame){
            if (turn == 1){
                CurrentTurn = player;
                Battle(player, Ai);
                turn = 2;
                BasicCommand.pause();
            }else {
                CurrentTurn = Ai;
                battleAi(Ai, player);
                turn = 1;
                BasicCommand.nextTurn();
                BasicCommand.pause();
            }
        }
        BasicCommand.tittle("Pertarungan berakhir\nHasilnya adalah");
        System.out.println(CurrentTurn + " adalah pemenang!!!");
        EndGame = false;
        return CurrentTurn == player;
    }

}
