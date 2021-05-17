package Model.Abstract;

public abstract class BasicAttribute {
    //name and descriptions
    protected String name;              //name (item, player, or enemy)
    protected String desc;              //descriptions about (item, player, or enemy)

    //stat characters
    protected int HP;                   //total health point
    protected int MP;                   //total mana point
    protected int PA;                   //total physical attack
    protected int MA;                   //total magic attack
    protected int def;                  //total defence
    protected int speed;                //total speed

    //getter
    @Override
    public String toString() {
        try {
            return name;
        } catch (NullPointerException n){
            return "";
        }

    } //return object to string (return name of this object)
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
    public int getDef() {
        return def;
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
    public void setDef(int def) {
        this.def = def;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
