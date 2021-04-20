package Controller.Commands;
import Model.Player;


public class BattleCommands{
    public void attack (Player player, Player enemy){

        String PlayerName = player.getPlayerName();
        int PlayerAttack = player.getPA();
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getRace().getMaxHP();
        player.setGuard(false);

        String EnemyName = enemy.getPlayerName();
        int EnemyDef = enemy.getDeff();
        int EnemyCurrentHP = enemy.getHP();
        int EnemyTotalHP = enemy.getRace().getMaxHP();

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

    public void guard (Player player){
        Race player1 = player.getRace();

        player.setGuard(true);
        System.out.println(player1.getName() + " Ready To Guard Next Attack");
        System.out.println("---------------Next Turn--------------");
    }

    public void skip(Player player){
        String PlayerName = player.getPlayerName();
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getRace().getMaxHP();

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

    public void showstatus(Player player){
        System.out.println(player.getPlayerName() + " Current Turn");
        System.out.println("HP         : " + player.getHP() + "/" + player.getRace().getMaxHP());
        System.out.println("HP         : " + player.getHP() + "/" + player.getRace().getMaxHP());
        System.out.println("MP         : " + player.getMP() + "/" + player.getRace().getMaxMP());
    }
}
