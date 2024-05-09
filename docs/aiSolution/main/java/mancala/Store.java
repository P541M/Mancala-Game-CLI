package mancala;

public class Store {
    private int totalStones;
    private Player owner;

    public Store() {
        this.totalStones = 0;
        this.owner = null;
    }

    public void addStones(int amount) {
        this.totalStones += amount;
    }

    public int emptyStore() {
        int stones = this.totalStones;
        this.totalStones = 0;
        return stones;
    }

    public Player getOwner() {
        return this.owner;
    }

    public int getTotalStones() {
        return this.totalStones;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public String toString() {
        return "Store: " + totalStones + " stone(s)," + " Owner: " + owner;
    }
}
