package mancala;

//AI Generated
public class Player {
    private String name; // private var to store name of player
    private Store store; // Private var to store the players store

    // Constructor, Initializes a new player.
    public Player() {
        this.name = "";
        this.store = new Store();
    }

    // Constructor, Initializes a new player with a name.
    public Player(String playerName) {
        this.name = playerName;
        this.store = new Store();
    }

    // Method, Gets the name of the player.
    public String getName() {
        return this.name; // Returns the players name
    }

    // Method, Gets the player's store where they collect stones.
    public Store getStore() {
        return this.store; // returns the players store
    }

    // Method, Gets the cound of the number of stones in the player's store where
    // they collect stones.
    public int getStoreCount() {
        return this.store.getTotalStones(); // Returns total amount of stones in store
    }

    // Method, Sets the player's name.
    public void setName(String playerName) {
        this.name = playerName; // Sets the players name
    }

    // Method, Sets the player's store.
    public void setStore(Store newStore) {
        this.store = newStore; // Sets the store to a specific store
    }

    @Override
    public String toString() {
        return "Player: " + this.name + ", Store: " + this.store.getTotalStones() + " stones";
    }
}