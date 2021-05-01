package Data.Item;

import Data.DataItem;
import Model.Enum.TypeEquip;
import Model.ItemType.Equipable;

public class DataEquipable extends DataItem {
    public DataEquipable(){
        this.DataItem.put(1, new Equipable(1,"Sword","",500,0,45,0,5,3, TypeEquip.WEAPONS,100));
        this.DataItem.put(2, new Equipable(2,"dagger","",250,100,30,0,0,50, TypeEquip.WEAPONS,100));
        this.DataItem.put(3, new Equipable(3,"staff","",0,500,10,45,0,5, TypeEquip.WEAPONS,100));
    }

    @Override
    public Equipable getItem(int id) {
        return (Equipable) DataItem.get(id);
    }
}
