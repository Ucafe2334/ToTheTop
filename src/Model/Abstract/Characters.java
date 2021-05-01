package Model.Abstract;

public abstract class Characters extends BasicAttribute{
    protected int MaxHP;
    protected int MaxMP;
    protected boolean Guard = false; //status on guard position or not

    protected int gold;
    protected boolean isDead;

    public boolean isDead() {
        isDead = this.HP < 1;
        return isDead;
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

    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }
    public void setMaxMP(int maxMP) {
        MaxMP = maxMP;
    }
    public void setGuard(boolean guard) {
        Guard = guard;
    }

}
