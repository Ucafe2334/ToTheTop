package Model;

public class BasicAttribute {
    //name and descriptions
    protected String name;
    protected String desc;

    //stat characters
    protected int MaxHP;
    protected int MaxMP;
    protected int HP; //total health poin player
    protected int MP; //total mana poin player
    protected int PA; //total physical attack player
    protected int MA; //total magic attack player
    protected int deff; //total defence player
    protected int speed; //total speed player
    protected boolean Guard = false; //status on guard position or not

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public int getHP() {
        return HP;
    }
    public int getMP() {
        return MP;
    }
    public int getPA() {
        return PA;
    }
    public int getMA() {
        return MA;
    }
    public int getDeff() {
        return deff;
    }
    public int getSpeed() {
        return speed;
    }
    public boolean isGuard() {
        return Guard;
    }
    public int getMaxHP() {
        return MaxHP;
    }
    public int getMaxMP() {
        return MaxMP;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setMP(int MP) {
        this.MP = MP;
    }
    public void setPA(int PA) {
        this.PA = PA;
    }
    public void setMA(int MA) {
        this.MA = MA;
    }
    public void setDeff(int deff) {
        this.deff = deff;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setGuard(boolean guard) {
        Guard = guard;
    }
}
