package BaseClass;

public class Race {
    private String raceName;
    private String raceDesc;

    private final int MaxHP;
    private final int MaxMP;

    private int STR;
    private int INT;
    private int EN;
    private int AGI;

    public Race(String name, String desc, int HP, int MP, int maxHP, int MAXMP, int STR, int INT, int EN, int AGI) {
        raceName = name;
        raceDesc = desc;
        MaxHP = maxHP;
        this.MaxMP = MAXMP;
        this.STR = STR;
        this.INT = INT;
        this.EN = EN;
        this.AGI = AGI;
    }

    //Getter
    public String getName() {
        return raceName;
    }
    public String getRaceDesc() {
        return raceDesc;
    }
    public int getMaxHP() {
        return MaxHP;
    }
    public int getMaxMP() {
        return MaxMP;
    }
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
