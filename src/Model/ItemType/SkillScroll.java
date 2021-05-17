package Model.ItemType;

import Model.Abstract.Item;
import Model.Enum.TypeItem;
import Model.Skill;

public class SkillScroll extends Item {
    private Skill carry;

    public SkillScroll(int id, String name, String desc, int cost, Skill skill) {
        super(name,desc, TypeItem.SkillScroll,cost);

        this.carry = skill;
    }
}
