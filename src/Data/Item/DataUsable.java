package Data.Item;

import Data.DataItem;
import Model.ItemType.Usable;

public class DataUsable extends DataItem {
    public DataUsable() {
        DataItem.put(1,new Usable(
                "Low Health Potion",
                "this is just a low potion, cheaper than other, but just regenerate some health potion",
                500,0,100));
        DataItem.put(2,new Usable(
                "Low Mana Potion",
                "this is just a low potion, cheaper than other, but just regenerate some mana potion",
                0,500,100));
        DataItem.put(1,new Usable(
                "High Health Potion",
                "this is just a high potion, but just regenerate some health potion",
                500,0,100));
        DataItem.put(2,new Usable(
                "High Mana Potion",
                "this is just a high potion, but just regenerate some mana potion",
                0,500,100));
    }

    @Override
    public Usable getItem(int id) {
        return (Usable) DataItem.get(id);
    }
}
