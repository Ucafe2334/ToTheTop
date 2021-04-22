package Data;

import Model.Item;
import Model.ItemType.Usable;

import java.util.HashMap;
import java.util.Map;

public class DataItem {
    private final HashMap<Integer, Item> DataItem = new HashMap<>();

    public DataItem(){
        this.DataItem.put(1, new Usable("Low Grade Potion","",500,0));
    }

    public void getItem(){
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();

            System.out.println(id + "> " + idItem.getName());
            System.out.println(idItem.getDesc());
        }
    }

    public void getItem(Item.type type){
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();
            if (idItem.getItemType() == type){
                System.out.println(id + "> " + idItem.getName());
                System.out.println(idItem.getDesc());
            }
        }
    }

    public Item getItem(int id){
        return DataItem.get(id);
    }
}
