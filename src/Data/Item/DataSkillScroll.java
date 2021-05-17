package Data.Item;

import Data.DataItem;
import Model.ItemType.SkillScroll;
import Model.Skill;

public class DataSkillScroll extends DataItem {
    private static final String descTemplate = "Use to get this skill";

    public DataSkillScroll() {
        DataItem.put(1, new SkillScroll(
                1, "Double Attack Scroll",
                descTemplate,
                100,
                new Skill("Double Attack",
                        " inflict two hits instead of one",
                        100, 150)
        ));
        DataItem.put(2, new SkillScroll(
                2, "Fireball Scroll",
                descTemplate,
                500,
                new Skill("Fireball",
                        "weak magic, but can burn anything",
                        100, 150, 100)
        ));
        DataItem.put(3, new SkillScroll(
                3, "Heal Scroll",
                descTemplate,
                300,
                new Skill("Heal",
                        "weak HP restoration for 1 person (self)",
                        0, 100, 150, 100)
        ));
        DataItem.put(4, new SkillScroll(
                4, "Fire Slash",
                descTemplate,
                700,
                new Skill("Fire Slash",
                        "infilct hit with fire",
                        100, 100, 100, 100, 100)
        ));
    }

    @Override
    public SkillScroll getItem(int id) {
        return (SkillScroll) DataItem.get(id);
    }
}