package GameSystem;

import BaseClass.Item;
import BaseClass.Race;
import BaseClass.Weapon;

public class Player {
    //ini yang bakal berubah
    private String playerName;
    protected Race race; //choosen Race
    private int HP; //total health poin player
    private int MP; //total mana poin player
    private int PA; //total physical attack player
    private int MA; //total magic attack player
    private int deff; //total defence player
    private int speed; //total speed player
    private boolean Guard; //status on guard position or not

    //equiped
    private Weapon weapon; //weapon yang di equip
    //armor yang di equip
    //accesories yang di equip

    //inventory
    private Item[] inventory;
    private int Cap;


    public Player(String name, Race race) {
        this.playerName = name;
        this.race = race;
        this.HP = race.getMaxHP();
        this.MP = race.getMaxMP();
        this.PA = race.getSTR()*5;
        this.MA = (race.getSTR()+(race.getINT()*5))/2;
        this.deff = race.getEN()*3+ race.getSTR();
        this.speed = race.getAGI()*2- race.getEN();
        this.weapon = weapon;
        Cap = 0;
        Guard = false;
    }

    public String getPlayerName() {
        return playerName;
    }
    public Race getRace() {
        return race;
    }
    public int getMA() {
        return MA;
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
    public int getDeff() {
        return deff;
    }
    public int getSpeed() {
        return speed;
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public void getAllInventory(){
       Item[] allItem = this.inventory;
        for(int i=0;i<50;i++){
           Item item = allItem[i];
           System.out.println(i+1+")");
           System.out.println(item.getName());
           System.out.println(item.getDesc());
        }
    }
    public Item getInventoryItem(int i){
        Item[] allItem = this.inventory;
        return allItem[i];
    }
    boolean isDead(){
        return this.getHP() <= 0;
    }
    public boolean isGuard() {
        return Guard;
    }

    public void setGuard(boolean guard) {
        Guard = guard;
    }
    public void setRace(Race race) {
        this.race = race;
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
    public void setDeff(int deff) {
        this.deff = deff;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
