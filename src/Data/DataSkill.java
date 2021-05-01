package Data;

import Model.Skill;

import java.util.HashMap;
import java.util.Map;

public class DataSkill {
    protected final HashMap<Integer, Skill> DataSkill = new HashMap<>();

    public DataSkill(){
        this.DataSkill.put(1,new Skill("Double Attack",
                " inflict two hits instead of one",
                100,150));
        this.DataSkill.put(2, new Skill("Fireball",
                "weak magic, but can burn anything",
                100,150,100));
        this.DataSkill.put(3, new Skill("Heal",
                "weak HP restoration for 1 person (self)",
                100,0,150,100));
        this.DataSkill.put(4, new Skill("Fire Slash",
                "infilct hit with fire",
                100,100,100,100,100));
    }

    public void getSkill(){
        for (Map.Entry<Integer, Skill> entry: DataSkill.entrySet()){
            Integer id = entry.getKey();
            Skill idSkill = entry.getValue();

            System.out.println(id + "> " + idSkill.getName());
            System.out.println("desc : " + idSkill.getDesc());
        }
    }

    public Skill getSkill(int id){
        return DataSkill.get(id);
    }
}
