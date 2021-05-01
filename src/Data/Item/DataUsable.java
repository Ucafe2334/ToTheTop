package Data.Item;

import Data.DataItem;
import Model.ItemType.Usable;

public class DataUsable extends DataItem {
    public DataUsable() {
        DataItem.put(1,new Usable(
                1,
                "Low Health Potion",
                "this is just a low potion, cheaper than other, but just regenerate some health potion",
                500,0,100));
    }

    @Override
    public Usable getItem(int id) {
        return (Usable) DataItem.get(id);
    }
}
