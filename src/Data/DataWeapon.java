package Data;

import Model.Weapon;
import java.util.HashMap;
import java.util.Map;

public class DataWeapon {
    private final HashMap<Integer, Weapon> DataWeapon = new HashMap<>();

    public DataWeapon(){
        this.DataWeapon.put(1, new Weapon("Sword",10,0,0,0));
        this.DataWeapon.put(2, new Weapon("knife",8,5,0,10));
        this.DataWeapon.put(3, new Weapon("Hammer",15,0,10,-2));
    }

    public void getWeapon(){
        for (Map.Entry<Integer,Weapon> entry: DataWeapon.entrySet()){
            Integer id = entry.getKey();
            Weapon idWeapon = entry.getValue();

            System.out.println(id+"> "+idWeapon.getName());
            System.out.println("STR/INT/EN/AGI");
            System.out.println(idWeapon.getSTR() + "/" + idWeapon.getINT() + "/" + idWeapon.getEN() + "/" + idWeapon.getAGI());
            System.out.println(" ");
        }
    }

    public Weapon getWeapon(int id){
        return DataWeapon.get(id);
    }
}
