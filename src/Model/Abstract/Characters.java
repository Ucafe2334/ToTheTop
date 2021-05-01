package Model.Abstract;

public abstract class Characters extends BasicAttribute{
    protected int MaxHP;                //total Max HP Characters
    protected int MaxMP;                //total Max MP Characters
    protected boolean Guard = false;    //status on guard position or not

    protected int gold;                 //gold that Characters have (drop coin for enemy)
    protected boolean isDead;           //status Characters is dead or alive

    //getter
    public boolean isDead() {
        return isDead = this.HP < 1;
    }
    public int getGold() {
        return gold;
    }
    public int getMaxHP() {
        return MaxHP;
    }
    public int getMaxMP() {
        return MaxMP;
    }
    public boolean isGuard() {
        return Guard;
    }

    //setter
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }
    public void setMaxMP(int maxMP) {
        MaxMP = maxMP;
    }
    @Override
    public void setHP(int HP) {
        if (HP < 0){
            this.HP = 0;
        } else if (HP > this.MaxHP){
            this.HP = MaxHP;
        } else {
            this.HP = HP;
        }
    }
    @Override
    public void setMP(int MP) {
        if (MP < 0){
            this.MP = 0;
        } else if (MP > MaxMP){
            this.MP = MaxMP;
        } else {
            this.MP = MP;
        }
    }
    public void setGuard(boolean guard) {
        Guard = guard;
    }

}
