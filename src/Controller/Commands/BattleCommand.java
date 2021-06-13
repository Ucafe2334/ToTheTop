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

        System.out.println(player + " menyerang " + enemy);
        if (PlayerAttack < EnemyDef && enemy.isGuard()){
            System.out.println(enemy + " dalam keadaan bertahan, serangan berhasil dikembalikan");

            Result = EnemyDef-PlayerAttack;
            player.setHP(PlayerCurrentHP - Result);

            System.out.println(player + " terkena " + Result + " Damage");
            System.out.println("HP menurun menjadi " + player.getHP() + "/" + PlayerMaxHP);
        } else if (PlayerAttack == EnemyDef && enemy.isGuard()){
            System.out.println("serangan berhasil digagalkan");
        }else{
            Result = PlayerAttack-EnemyDef;
            enemy.setHP(EnemyCurrentHP - Result);

            System.out.println(enemy + " terkena " + Result + " Damage");
            System.out.println(("HP menurun menjadi " + enemy.getHP() + "/" + EnemyTotalHP));
        }
    }

    static void guard (Characters player){
        player.setGuard(true);
        System.out.println(player + " bersiap untuk menangkis serangan");
    }

    static void skip(Characters player){
        int PlayerCurrentHP = player.getHP();
        int PlayerMaxHP = player.getMaxHP();

        player.setGuard(false);
        int Result = (int) (PlayerMaxHP*0.1);

        if (PlayerCurrentHP < PlayerMaxHP){
            player.setHP(PlayerCurrentHP + Result);
            System.out.println(player + " memulihkan " + Result + " HP");
            System.out.println("HP berhasil dipulihkan menjadi " + PlayerCurrentHP + "/" + PlayerMaxHP);
        } else {
            System.out.println(player + " tidak melakukan apapun");
        }
    }

    static void useItem(Player player){
        player.getInventory(TypeItem.UsableItem);

        int selected = BasicCommand.inputint("Pilih Item");
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
        PlayerCommand.showSkill(player);

        int selected = BasicCommand.inputint("pilih skill yang ingin digunakan");
        Skill dummy = SkillCommand.skillSelected(player,selected);
        if (dummy != null){
            if (dummy.getManaCost() < player.getMP()){
                SkillCommand.skillUse(player,enemy,dummy);
            }else {
                System.out.println("MP kurang untuk melakukan skill");
            }
        } else {
            System.out.println("skill tidak ditemukan");
            System.out.println("giliranmu dilewat");
        }
    }

    static void showstatus(Characters player){
        System.out.println("giliran " + player);
        System.out.println("HP         : " + player.getHP() + "/" + player.getMaxHP());
        System.out.println("MP         : " + player.getMP() + "/" + player.getMaxMP());
    }
}

