package Model;

public class Characters extends BasicAttribute {
    protected enum type {PLAYER, ENEMY, NPC}
    type charType;
    protected int gold;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
