package Data;

import Model.Abstract.Item;
import Model.ItemType.SkillScroll;
import Model.Player;
import Model.Skill;

import java.util.HashMap;
import java.util.Map;

public class DataSkill {
    private final HashMap<Integer, Skill> DataSkill = new HashMap<>();
    private static final String descTemplate = "Use to get this skill";

    public DataSkill() {
        DataSkill.put(1,
                new Skill("Double Attack",
                        " inflict two hits instead of one",
                        100, 150,500)
        );
        DataSkill.put(2,
                new Skill("Fireball",
                        "weak magic, but can burn anything",
                        100, 150, 100,700)
        );
        DataSkill.put(3,
                new Skill("Heal",
                        "weak HP restoration for 1 person (self)",
                        0, 100, 150, 100,1000)
        );
        DataSkill.put(4,
                new Skill("Fire Slash",
                        "inflict hit with fire to enemy",
                        100, 100, 100, 100, 100,1200)
        );
    }

    public void getSkill(Player target){
        for (Map.Entry<Integer, Skill> entry: DataSkill.entrySet()){
            Integer id = entry.getKey();
            Skill idSkill = entry.getValue();

            System.out.println(id + "> " + idSkill+"\t"+target.skillAlreadyLearntoString(idSkill));
            System.out.println("price : "+idSkill.getCost());
            System.out.println("desc : "+idSkill.getDesc()+"\n");
        }
    }

    public Skill getSkill(int id) {
        return DataSkill.get(id);
    }
}