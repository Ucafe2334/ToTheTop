package Data;

import java.util.HashMap;
import java.util.Map;

import Model.ItemType.Equipable;

public class DataWeapon {
    private final HashMap<Integer, Equipable> DataWeapon = new HashMap<>();

    public DataWeapon(){
        this.DataWeapon.put(1, new Equipable("Sword","",500,0,45,0,5,3, Equipable.typeE.WEAPONS));
        this.DataWeapon.put(2, new Equipable("dagger","",250,100,30,0,0,50, Equipable.typeE.WEAPONS));
        this.DataWeapon.put(3, new Equipable("staff","",0,500,10,45,0,5, Equipable.typeE.WEAPONS));
    }

    public void getWeapon(){
        for (Map.Entry<Integer, Equipable> entry: DataWeapon.entrySet()){
            Integer id = entry.getKey();
            Equipable idWeapon = entry.getValue();

            System.out.println(id + "> " + idWeapon.getName());
            System.out.println("HP : " + idWeapon.getMaxHP());
            System.out.println("MP : " + idWeapon.getMaxMP());
            System.out.println("PA/MA/DEF/SPD");
            System.out.println(idWeapon.getPA() + "/" + idWeapon.getMA() + "/" + idWeapon.getDeff() + "/" + idWeapon.getSpeed());
            System.out.println(" ");
        }
    }

    public Equipable getWeapon(int id){
        return DataWeapon.get(id);
    }
}
