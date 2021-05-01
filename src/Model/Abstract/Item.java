package Model.Abstract;

import Model.Enum.*;

public abstract class Item extends BasicAttribute implements Comparable<Item> {
    protected int id;                   //id for item

    protected TypeItem typeI;
    protected int cost;
    protected int sell;
    protected int quantity = 0;

    public Item(){
        this.id = 0;
    }

    public Item(int id, String name, String desc, TypeItem typeI, int cost) {
        this.id = id;
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
    public int getId() {
        return id;
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
