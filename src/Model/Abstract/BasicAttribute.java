package Model.Abstract;

public abstract class BasicAttribute {
    //name and descriptions
    protected String name;
    protected String desc;

    //stat characters
    protected int HP; //total health poin
    protected int MP; //total mana poin
    protected int PA; //total physical attack
    protected int MA; //total magic attack
    protected int deff; //total defence
    protected int speed; //total speed

    //getter
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

    //setter
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
}
