package Data;

import Model.Abstract.Item;
import Model.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class DataItem {
    protected final HashMap<Integer, Item> DataItem = new HashMap<>();

    public void getItem(){
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();

            System.out.println(id + "> " + idItem);
            System.out.println("desc : "+idItem.getDesc());
        }
    }

    public void getItem(Player target){
        for (Map.Entry<Integer, Item> entry: DataItem.entrySet()){
            Integer id = entry.getKey();
            Item idItem = entry.getValue();

            System.out.println(id + "> " + idItem+"\tx"+target.getInventoryQuantity(idItem));
            System.out.println("price : "+idItem.getCost());
            System.out.println("desc : "+idItem.getDesc()+"\n");
        }
    }

    public Item getItem(int id){
        return DataItem.get(id);
    }
}
