package ClassData;

public class Race {
    private String Name;
    private String Desc;

    private int HP;
    private int MP;
    private int MaxHP;
    private int MAXMP;

    private int STR;
    private int INT;
    private int EN;
    private int AGI;

    private boolean GuardStatus = false;

    private Weapon EquipWeapon;

    public Race(String name, String desc, int HP, int MP, int maxHP, int MAXMP, int STR, int INT, int EN, int AGI) {
        Name = name;
        Desc = desc;
        this.HP = HP;
        this.MP = MP;
        MaxHP = maxHP;
        this.MAXMP = MAXMP;
        this.STR = STR;
        this.INT = INT;
        this.EN = EN;
        this.AGI = AGI;
    }

    //Getter
    public String getName() {
        return Name;
    }
    public String getDesc() {
        return Desc;
    }
    public int getHP() {
        return HP;
    }
    public int getMP() {
        return MP;
    }
    public int getMaxHP() {
        return MaxHP;
    }
    public int getMAXMP() {
        return MAXMP;
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
    public boolean isGuardStatus() {
        return GuardStatus;
    }

    //Setter
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setMP(int MP) {
        this.MP = MP;
    }
    public void setSTR(int STR) {
        this.STR = STR;
    }
    public void setINT(int INT) {
        this.INT = INT;
    }
    public void setEN(int EN) {
        this.EN = EN;
    }
    public void setAGI(int AGI) {
        this.AGI = AGI;
    }
    public void setGuardStatus(boolean guardStatus) {
        GuardStatus = guardStatus;
    }

    void attack (Race Enemy){
        String PlayerName = this.getName();
        int PlayerAttack = this.getSTR();
        int PlayerCurrentHP = this.getHP();
        int PlayerMaxHP = this.getMaxHP();
        this.setGuardStatus(false);

        String EnemyName = Enemy.getName();
        int EnemyDef = Enemy.getEN();
        int EnemyCurrentHP = Enemy.getHP();
        int EnemyTotalHP = Enemy.getMaxHP();

        int Result;

        System.out.println(PlayerName + " is Attacking " + EnemyName);
        if (PlayerAttack < EnemyDef){
            System.out.println(EnemyName + " in Full Guard, Attack Has Been Deflected");

            Result = EnemyDef*2-PlayerAttack;
            this.setHP(PlayerCurrentHP - Result);

            System.out.println(PlayerName + " took " + Result + "Demage");
            System.out.println("HP Drop Become " + this.getHP() + "/" + PlayerMaxHP);
        } else if (PlayerAttack == EnemyDef){
            System.out.println("Attack Has Been Guarded/nNo One Take Demage");
        }else{
            Result = PlayerAttack*2-EnemyDef;
            Enemy.setHP(EnemyCurrentHP - Result);

            System.out.println(EnemyName + " took " + Result + "Demage");
            System.out.println(("HP Drop Become " + Enemy.getHP() + "/" + EnemyTotalHP));
        }

        System.out.println("---------------Next Turn--------------");
    }

    void guard (){
        this.setGuardStatus(true);
        System.out.println(this.getName() + " Ready To Guard Next Attack");
        System.out.println("---------------Next Turn--------------");
    }

    void skip(){
        String PlayerName = this.getName();
        int PlayerCurrentHP = this.getMaxHP();
        int PlayerMaxHP = this.getMaxHP();

        this.setGuardStatus(false);
        int Result = (int) (PlayerCurrentHP*0.1);

        if (PlayerCurrentHP < PlayerMaxHP){
            this.setHP(PlayerCurrentHP + Result);
            System.out.println(PlayerName + " Recovery " + Result + " HP");
            System.out.println("HP Grow Become " + PlayerCurrentHP + "/" + PlayerMaxHP);
        } else {
            System.out.println(PlayerName + " Just Take Some Rest");
        }
        System.out.println("---------------Next Turn--------------");
    }

    boolean isDead(){
        return this.getHP() <= 0;
    }

    void showstatus(){
        System.out.println(this.getName() + " Current Turn");
        System.out.println("HP         : " + this.getHP() + "/" + this.getMaxHP());
        System.out.println("MP         : " + this.getMP() + "/" + this.getMAXMP());
    }

    public void setWeapon (Weapon wp){
        this.EquipWeapon = wp;
        this.setSTR(getSTR() + wp.getSTR());
        this.setINT(getINT() + wp.getINT());
        this.setEN(getEN() + wp.getEN());
        this.setAGI(getAGI() + wp.getAGI());
    }
}
