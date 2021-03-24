package BaseClass;

public class Item {
    protected String Name;
    protected String Desc;
    protected String Type;

    //status yang di dapet kalau menggunakan atau memakai item ini
    protected int HP;
    protected int MP;
    protected int AP;
    protected int deff;
    protected int speed;

    public String getDesc() {
        return Desc;
    }
    public String getName() {
        return Name;
    }
    public String getType() {
        return Type;
    }
    public int getHP() {
        return HP;
    }
    public int getMP() {
        return MP;
    }
    public int getAP() {
        return AP;
    }
    public int getDeff() {
        return deff;
    }
    public int getSpeed() {
        return speed;
    }
}
