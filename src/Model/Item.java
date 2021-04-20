package Model;

public class Item extends BasicAttribute{
    protected enum type {USABLE, EQUIPABLE, CRAFTABLE};
    protected String types;
    protected type itemType;

    public void usingItem(){

    }
}
