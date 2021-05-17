package Controller.Commands;

import Model.Abstract.Characters;
import Model.Enemy;
import Model.Enum.TypeItem;
import Model.Abstract.Item;
import Model.Player;
import Model.Skill;

public interface BattleCommand extends PlayerCommand,BasicCommand{
    static void attack (Characters player, Characters enemy){

        int PlayerAttack = player.getPA();
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getMaxHP();
        player.setGuard(false);

        int EnemyDef = enemy.getDef();
        int EnemyCurrentHP = enemy.getHP();
        int EnemyTotalHP = enemy.getMaxHP();

        int Result;

        System.out.println(player + " is Attacking " + enemy);
        if (PlayerAttack < EnemyDef && enemy.isGuard()){
            System.out.println(enemy + " in Full Guard, Attack Has Been Deflected");

            Result = EnemyDef-PlayerAttack;
            player.setHP(PlayerCurrentHP - Result);

            System.out.println(player + " took " + Result + "Damage");
            System.out.println("HP Drop Become " + player.getHP() + "/" + PlayerMaxHP);
        } else if (PlayerAttack == EnemyDef && enemy.isGuard()){
            System.out.println("Attack Has Been Guarded/nNo One Take Damage");
        }else{
            Result = PlayerAttack-EnemyDef;
            enemy.setHP(EnemyCurrentHP - Result);

            System.out.println(enemy + " took " + Result + " Damage");
            System.out.println(("HP Drop Become " + enemy.getHP() + "/" + EnemyTotalHP));
        }
    }

    static void guard (Characters player){
        player.setGuard(true);
        System.out.println(player + " Ready To Guard Next Attack");
    }

    static void skip(Characters player){
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getMaxHP();

        player.setGuard(false);
        int Result = (int) (PlayerMaxHP*0.1);

        if (PlayerCurrentHP < PlayerMaxHP){
            player.setHP(PlayerCurrentHP + Result);
            System.out.println(player + " Recovery " + Result + " HP");
            System.out.println("HP recovered become " + PlayerCurrentHP + "/" + PlayerMaxHP);
        } else {
            System.out.println(player + " Just Took Some Rest");
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

    static void useSkill(Player player, Enemy enemy){
        array.add(player.getSlot1().toString());
        array.add(player.getSlot2().toString());
        array.add(player.getSlot3().toString());

        BasicCommand.printMenu();
        int selected = BasicCommand.inputint();
        Skill dummy = SkillCommand.skillSelected(player,selected);
        if (dummy != null){
            SkillCommand.skillUse(player,enemy,dummy);
        } else {
            System.out.println("Skill not found");
        }
    }

    static void showstatus(Characters player){
        System.out.println(player + " Current Turn");
        System.out.println("HP         : " + player.getHP() + "/" + player.getMaxHP());
        System.out.println("MP         : " + player.getMP() + "/" + player.getMaxMP());
    }
}

