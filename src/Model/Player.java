package Model;

public class Player extends Characters {
    //equiped
    private Weapon weapon; //weapon yang di equip
    //armor yang di equip
    //accesories yang di equip

    //inventory
    private Item[] inventory;
    private int Cap;

    //constructor
    public Player(String playerName, String desc, int hp, int mp, int pa, int ma, int deff, int spd) {
        this.name = playerName;
        this.desc = desc;

        this.HP = hp;
        this.MP = mp;
        this.MaxHP = hp;
        this.MaxMP = mp;
        this.PA = pa;
        this.MA = ma;
        this.deff = deff;
        this.speed = spd;

    }

    //getter
    public Weapon getWeapon() {
        return weapon;
    }

    //setter
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
