package mancala;

//AI Generated
public class Pit {
    // Private var for storing the number of stones in a pit
    private int stoneCount;

    // Constructor, Initializes a new pit.
    public Pit() {
        this.stoneCount = 0; // Sets a pit to 0 (initializing it)
    }

    // Method, Adds a stone to the pit.
    public void addStone() {
        this.stoneCount++;
    }

    // Method, Gets the number of stones in the pit.
    public int getStoneCount() {
        return this.stoneCount;
    }

    // Method, Removes and returns the stones from the pit.
    public int removeStones() {
        int removedStones = this.stoneCount;
        this.stoneCount = 0; // Reset stone count
        return removedStones; // return the remove stones
    }
    //End of AI generation

    // Helper method, to fill in all pits with 4 stones
    public void setPits() {
        stoneCount = 4; // Set the pits to contain 4 stones
    }

    @Override
    public String toString() {
        return "Pit: " + this.stoneCount + " stone(s)";
    }
}