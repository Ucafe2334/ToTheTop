package Model.Abstract;

import Model.Enum.*;

public abstract class Item extends BasicAttribute implements Comparable<Item> {
    protected TypeItem typeI;
    protected int cost;
    protected int sell;
    protected int quantity = 0;


    public Item(String name, String desc, TypeItem typeI, int cost) {
        this.name = name;
        this.desc = desc;
        this.typeI = typeI;
        this.cost = cost;
        this.sell = cost - (int) (cost*0.2);
    }

    public TypeItem getTypeI() {
        return typeI;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getCost() {
        return cost;
    }
    public int getSell() {
        return sell;
    }

    public void addQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }
    public void removeSome(int quantity) {
        this.quantity = this.quantity - quantity;
    }
    public void removeAll(){this.quantity = 0;}

    @Override
    public int compareTo(Item o) {
        return this.getTypeI().compareTo(o.getTypeI());
    }
}
