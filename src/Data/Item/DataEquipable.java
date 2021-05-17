package Data.Item;

import Data.DataItem;
import Model.Abstract.Item;
import Model.Enum.TypeEquip;
import Model.ItemType.Equipable;
import Model.Player;

import java.util.Map;

public class DataEquipable extends DataItem {
    public DataEquipable(){
        this.DataItem.put(1, new Equipable("Sword","",500,0,45,0,5,3, TypeEquip.WEAPONS,100));
        this.DataItem.put(2, new Equipable("dagger","",250,100,30,0,0,50, TypeEquip.WEAPONS,100));
        this.DataItem.put(3, new Equipable("staff","",0,500,10,45,0,5, TypeEquip.WEAPONS,100));
    }

    @Override
    public void getItem(Player target) {
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();

            System.out.println(id + "> " + idItem+"\tx"+target.getInventoryQuantity(idItem));
            System.out.println("price : "+idItem.getCost());
            System.out.println("HP/MP/PA/MA/DEF/SPD");
            System.out.println(idItem.getHP()+"/"+idItem.getMP()+"/"+idItem.getPA() + "/" + idItem.getMA() + "/" + idItem.getDef() + "/" + idItem.getSpeed()+"\n");
        }
    }

    @Override
    public Equipable getItem(int id) {
        return (Equipable) DataItem.get(id);
    }
}
