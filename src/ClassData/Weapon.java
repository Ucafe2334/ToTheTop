package ClassData;

public class Weapon {
    private String Name;
    private String Desc;
    private int STR;
    private int INT;
    private int EN;
    private int AGI;

    public Weapon(String name, int STR, int INT, int EN, int AGI) {
        Name = name;
        this.STR = STR;
        this.INT = INT;
        this.EN = EN;
        this.AGI = AGI;
    }

    public String getName() {
        return Name;
    }
    public String getDesc() { return Desc;}
    public int getSTR() {
        return STR;
    }
    public int getINT() {
        return INT;
    }
    public int getEN() {
        return EN;
    }
    public int getAGI() {
        return AGI;
    }
}
