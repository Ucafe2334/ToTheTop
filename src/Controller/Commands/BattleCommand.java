package Controller.Commands;

import Model.Abstract.Characters;
import Model.Enum.TypeItem;
import Model.Abstract.Item;
import Model.Player;

public interface BattleCommand extends PlayerCommand,BasicCommand{
    static void attack (Characters player, Characters enemy){

        String PlayerName = player.getName();
        int PlayerAttack = player.getPA();
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getMaxHP();
        player.setGuard(false);

        String EnemyName = enemy.getName();
        int EnemyDef = enemy.getDef();
        int EnemyCurrentHP = enemy.getHP();
        int EnemyTotalHP = enemy.getMaxHP();

        int Result;

        System.out.println(PlayerName + " is Attacking " + EnemyName);
        if (PlayerAttack < EnemyDef && enemy.isGuard()){
            System.out.println(EnemyName + " in Full Guard, Attack Has Been Deflected");

            Result = EnemyDef-PlayerAttack;
            player.setHP(PlayerCurrentHP - Result);

            System.out.println(PlayerName + " took " + Result + "Damage");
            System.out.println("HP Drop Become " + player.getHP() + "/" + PlayerMaxHP);
        } else if (PlayerAttack == EnemyDef && enemy.isGuard()){
            System.out.println("Attack Has Been Guarded/nNo One Take Damage");
        }else{
            Result = PlayerAttack-EnemyDef;
            enemy.setHP(EnemyCurrentHP - Result);

            System.out.println(EnemyName + " took " + Result + " Damage");
            System.out.println(("HP Drop Become " + enemy.getHP() + "/" + EnemyTotalHP));
        }
    }

    static void guard (Characters player){
        player.setGuard(true);
        System.out.println(player.getName() + " Ready To Guard Next Attack");
    }

    static void skip(Characters player){
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
            System.out.println(PlayerName + " Just Took Some Rest");
        }
    }

    static void useItem(Player player){
        player.getInventory(TypeItem.UsableItem);

        int selected = BasicCommand.inputint("Choose Item");
        Item item = player.getInventory(selected-1);
        PlayerCommand.usingItem(player,item);
        if (item.getQuantity() > 1){
            item.removeSome(1);
            player.replaceInventory(selected-1,item);
        } else {
            player.removeItem(selected-1);
        }
    }

    static void showstatus(Characters player){
        System.out.println(player.getName() + " Current Turn");
        System.out.println("HP         : " + player.getHP() + "/" + player.getMaxHP());
        System.out.println("MP         : " + player.getMP() + "/" + player.getMaxMP());
    }
}
