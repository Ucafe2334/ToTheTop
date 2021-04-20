package Model;

public class Characters extends BasicAttribute {
    protected enum type {PLAYER, ENEMY, NPC}
    type charType;
    protected int gold;
    protected boolean isDead;

    public boolean isDead() {
        isDead = this.HP < 0;
        return isDead;
    }
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

}
