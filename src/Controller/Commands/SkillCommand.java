package Controller.Commands;

import Model.Enum.TypeAttribute;
import Model.Player;
import Model.Skill;

public interface SkillCommand {

    static void skillUse(Player target, Skill skill){
        int damagePA = 0;
        int damageMA = 0;
        int healHP = 0;
        int healMP = 0;
        if (skill.getAttribute() == TypeAttribute.physical){
            damagePA += skill.getBasePA()+(target.getPA() * skill.getPercentagePA());

        }else if (skill.getAttribute() == TypeAttribute.magic){
            damageMA = skill.getBaseMA()+(target.getMA() * skill.getPercentageMA());
        }else if (skill.getAttribute() == TypeAttribute.buff){
            if (skill.getHP() != 0){
                healHP = skill.getHP()+(target.getMA()+skill.getPercentageMA());
            }
            if (skill.getMP() != 0){
                healMP = skill.getMP()+(target.getMA()+skill.getPercentageMA());
            }
        }else if (skill.getAttribute() == TypeAttribute.physicalAndMagic){
            damagePA += skill.getBasePA()+(target.getPA() * skill.getPercentagePA());
            damageMA = skill.getBaseMA()+(target.getMA() * skill.getPercentageMA());
        }

        target.setHP(target.getHP()-damageMA-damagePA+healHP);
        target.setMP(target.getMP()+healMP-skill.getManaCost());
    }
}
