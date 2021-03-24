package Engines;

import BaseClass.Race;
import BaseClass.Weapon;

public class Player {
    //ini yang bakal berubah
    private String playerName;
    protected Race race; //ras yang dipilih
    private int HP; //health poin player
    private int MP; //mana poin player
    private int PA; //physical attack player
    private int MA; //magic attack player
    private int deff; //defence player
    private int speed; //speed player
    private boolean Guard; //status dalam posisi guard

    //equiped
    private Weapon weapon; //weapon yang di equip

    //inventory
    // Item [50];
    //int Cap;


    public Player(String name, Race race) {
        this.playerName = name;
        this.race = race;
        this.HP = race.getMaxHP();
        this.MP = race.getMaxMP();
        this.PA = race.getSTR()*5;
        this.MA = (race.getSTR()+(race.getINT()*5))/2;
        this.deff = race.getEN()*3+ race.getSTR();
        this.speed = race.getAGI()*2- race.getEN();
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
