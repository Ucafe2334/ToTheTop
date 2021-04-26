package Data;

import Model.Enum.TypeItem;
import Model.Item;

import java.util.HashMap;
import java.util.Map;

public class DataItem {
    protected final HashMap<Integer, Item> DataItem = new HashMap<>();

    public void getItem(){
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();

            System.out.println(id + "> " + idItem.getName());
            System.out.println(idItem.getDesc());
        }
    }

    public Item getItem(int id){
        return DataItem.get(id);
    }
}
