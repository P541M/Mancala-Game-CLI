package mancala;

//AI Generated
public class Store {
    private int totalStones; // Private var to store total num of stones in store
    private Player owner; // Private var to store own of store

    // Constructor, Initializes a new store.
    public Store() {
        this.totalStones = 0;
        this.owner = null;
    }

    // Method, Adds stones to the store.
    public void addStones(int amount) {
        this.totalStones += amount; // Increment total stone count by amount specified
    }

    // Method, Empties the store and returns the number of stones that were in it.
    public int emptyStore() {
        int stones = this.totalStones;
        this.totalStones = 0; // Reset total stone count in stores
        return stones; // Return the number of stones that were in the store
    }

    // Method, Gets the owner of the store.
    public Player getOwner() {
        return this.owner; // Returns the owner
    }

    // Method, Gets the total number of stones in the store.
    public int getTotalStones() {
        return this.totalStones; // Return the total amount of stones in store
    }

    // Method, Sets the owner of the store.
    public void setOwner(Player player) {
        this.owner = player; // Sets the owner to the given store
    }

    @Override
    public String toString() {
        return "Store: " + totalStones + " stone(s)," + " Owner: " + owner;
    }
}
