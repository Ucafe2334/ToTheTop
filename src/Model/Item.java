package Model;

import Model.Enum.*;

public class Item extends BasicAttribute{
    protected TypeItem typeI;
    protected int cost;

    public Item(String name, String desc, TypeItem typeI, int cost) {
        this.name = name;
        this.desc = desc;
        this.typeI = typeI;
        this.cost = cost;
    }

    public TypeItem getTypeI() {
        return typeI;
    }

    public int getCost() {
        return cost;
    }
}
