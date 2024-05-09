package mancala;

import java.util.ArrayList;

public class Board {

    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player playerOne;
    private Player playerTwo;

    // Constructor
    public Board() {
        this.pits = new ArrayList<>();
        this.stores = new ArrayList<>();
        this.playerOne = null;
        this.playerTwo = null;
    }

    // Method to set up pits
    public void setUpPits() {
        // Implementation to establish 12 empty pits
        // ...
    }

    // Method to get the list of pits
    public ArrayList<Pit> getPits() {
        // Implementation to return the list of pits
        // ...
        return pits;
    }

    // Method to get the list of stores
    public ArrayList<Store> getStores() {
        // Implementation to return the list of stores
        // ...
        return stores;
    }

    // Method to set up stores
    public void setUpStores() {
        // Implementation to establish 2 empty stores
        // ...
    }

    // Method to initialize the board
    public void initializeBoard() {
        // Implementation to distribute stones on the board
        // ...
    }

    // Method to reset the board
    public void resetBoard() {
        // Implementation to redistribute stones while retaining players
        // ...
    }

    // Method to register players and connect them to their stores
    public void registerPlayers(Player one, Player two) {
        // Implementation to connect players to their stores
        // ...
    }

    // Method to move stones for a player starting from a specific pit
    public int moveStones(int startPit, Player player) throws InvalidMoveException {
        // Implementation to move stones and return the total number added to the store
        // ...
        return 0;
    }

    // Helper method to distribute stones into pits and stores, skipping the opponent's store
    public int distributeStones(int startingPoint) throws PitNotFoundException {
        // Implementation to distribute stones and return the total number added to pits and stores
        // ...
        return 0;
    }

    // Method to capture stones from the opponent's pits
    public int captureStones(int stoppingPoint) throws PitNotFoundException {
        // Implementation to capture stones and return the number of stones captured
        // ...
        return 0;
    }

    // Method to get the number of stones in a specific pit
    public int getNumStones(int pitNum) throws PitNotFoundException {
        // Implementation to return the number of stones in a specific pit
        // ...
        return 0;
    }

    // Method to check if one side of the board is empty
    public boolean isSideEmpty(int pitNum) throws PitNotFoundException {
        // Implementation to check if one side of the board is empty
        // ...
        return false;
    }

    // Override toString method
    @Override
    public String toString() {
        // Implementation for the toString method
        // ...
        return super.toString();
    }
}
