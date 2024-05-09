package mancala;

public class Player {
    private String name;
    private Store store;

    public Player() {
        this.name = "";
        this.store = new Store();
    }

    public Player(String playerName) {
        this.name = playerName;
        this.store = new Store();
    }

    public String getName() {
        return this.name;
    }

    public Store getStore() {
        return this.store;
    }

    public int getStoreCount() {
        return this.store.getTotalStones();
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    public void setStore(Store newStore) {
        this.store = newStore;
    }

    @Override
    public String toString() {
        return "Player: " + this.name + ", Store: " + this.store.getTotalStones() + " stones";
    }
}