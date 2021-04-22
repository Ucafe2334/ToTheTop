package Model;

public class Item extends BasicAttribute{
    public enum type {USABLE, EQUIPABLE, CRAFTABLE};
    protected type itemType;

    public type getItemType() {
        return itemType;
    }
}
