package Controller.Commands;
import Model.Characters;


public class BattleCommands{
    public void attack (Characters player, Characters enemy){

        String PlayerName = player.getName();
        int PlayerAttack = player.getPA();
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getMaxHP();
        player.setGuard(false);

        String EnemyName = enemy.getName();
        int EnemyDef = enemy.getDeff();
        int EnemyCurrentHP = enemy.getHP();
        int EnemyTotalHP = enemy.getMaxHP();

        int Result;

        System.out.println(PlayerName + " is Attacking " + EnemyName);
        if (PlayerAttack < EnemyDef && enemy.isGuard()){
            System.out.println(EnemyName + " in Full Guard, Attack Has Been Deflected");

            Result = EnemyDef-PlayerAttack;
            player.setHP(PlayerCurrentHP - Result);

            System.out.println(PlayerName + " took " + Result + "Demage");
            System.out.println("HP Drop Become " + player.getHP() + "/" + PlayerMaxHP);
        } else if (PlayerAttack == EnemyDef && enemy.isGuard()){
            System.out.println("Attack Has Been Guarded/nNo One Take Demage");
        }else{
            Result = PlayerAttack-EnemyDef;
            enemy.setHP(EnemyCurrentHP - Result);

            System.out.println(EnemyName + " took " + Result + " Demage");
            System.out.println(("HP Drop Become " + enemy.getHP() + "/" + EnemyTotalHP));
        }

        System.out.println("---------------Next Turn--------------");
    }

    public void guard (Characters player){
        player.setGuard(true);
        System.out.println(player.getName() + " Ready To Guard Next Attack");
        System.out.println("---------------Next Turn--------------");
    }

    public void skip(Characters player){
        String PlayerName = player.getName();
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getMaxHP();

        player.setGuard(false);
        int Result = (int) (PlayerMaxHP*0.1);

        if (PlayerCurrentHP < PlayerMaxHP){
            player.setHP(PlayerCurrentHP + Result);
            System.out.println(PlayerName + " Recovery " + Result + " HP");
            System.out.println("HP recovered become " + PlayerCurrentHP + "/" + PlayerMaxHP);
        } else {
            System.out.println(PlayerName + " Just Take Some Rest");
        }
        System.out.println("---------------Next Turn--------------");
    }

    public void showstatus(Characters player){
        System.out.println(player.getName() + " Current Turn");
        System.out.println("HP         : " + player.getHP() + "/" + player.getMaxHP());
        System.out.println("MP         : " + player.getMP() + "/" + player.getMaxMP());
    }
}
