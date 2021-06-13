package Controller.Commands;

import Model.Abstract.Characters;
import Model.Enum.TypeAttribute;
import Model.Player;
import Model.Skill;

public interface SkillCommand {

    static void skillUse(Characters self, Characters target, Skill skill){
        System.out.println(self + "menggunakan skill"+skill);
        if (!skill.getSelf()){
            skillToEnemy(self, target, skill);
        } else if (skill.getSelf()){
            skillToSelf(self,skill);
        }
    }

    static void skillToSelf(Characters self, Skill skill){
        int healHP = 0;
        int healMP = 0;
        if (skill.getHP() != 0){
            healHP = skill.getHP()+(self.getMA()+skill.getPercentageMA());
            System.out.println(self+" memulihkan "+healHP+" HP");
        }
        if (skill.getMP() != 0) {
            healMP = skill.getMP() + (self.getMA() + skill.getPercentageMA());
            self.setHP(self.getHP());
            System.out.println(self+" memulihkan "+healHP+" MP");
        }
        self.setHP(self.getHP()+healHP);
        self.setMP(self.getMP()+healMP-skill.getManaCost());


    }

    static void skillToEnemy(Characters self, Characters enemy, Skill skill){
        int damagePA = 0;
        int damageMA = 0;

        if (skill.getAttribute() == TypeAttribute.physical){
            damagePA += skill.getBasePA()+(self.getPA() * skill.getPercentagePA()/100);
            System.out.println(self+" memberikan "+damagePA+" serangan pisikal ke "+enemy);
        }else if (skill.getAttribute() == TypeAttribute.magic){
            damageMA = skill.getBaseMA()+(self.getMA() * skill.getPercentageMA()/100);
            System.out.println(self+" memberikan "+damagePA+" serangan pisikal ke "+enemy);
        }else if (skill.getAttribute() == TypeAttribute.physicalAndMagic){
            damagePA += skill.getBasePA()+(self.getPA() * skill.getPercentagePA()/100);
            damageMA = skill.getBaseMA()+(self.getMA() * skill.getPercentageMA()/100);
            System.out.println(self+" memberikan "+damagePA+" serangan pisikal dan "+damageMA+" serangan magis ke "+enemy);
        }
        enemy.setHP(enemy.getHP()-damageMA-damagePA);
    }

    static Skill skillSelected(Player user, int selected){
        if (selected == 1){
            return user.getSlot1();
        } else if (selected == 2){
            return user.getSlot2();
        } else if (selected == 3){
            return user.getSlot3();
        }else {
            return null;
        }
    }

    static boolean learnSkill(Player user, Skill skill){
        PlayerCommand.showSkill(user);
        int slot = BasicCommand.inputint("pasang di slot");

        if (slot == 1){
            user.setSlot1(skill);
        } else if(slot == 2){
            user.setSlot2(skill);
        } else if(slot == 3){
            user.setSlot3(skill);
        }else {
            System.out.println("slot salah");
            return false;
        }
        return true;
    }
}
