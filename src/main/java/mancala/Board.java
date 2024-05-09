package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private boolean isBonus = false; // False by default, will be adjusted accordingly
    private int currentPlayer = 2; // 0: Player 1, 1: Player 2
    private int knowPlayer = 0; // Used for capturing stones from the opponent

    // Constructor, Initializes a new Mancala board with pits and stores.
    public Board() {
        pits = new ArrayList<>(12); // Sets total pits to 12
        stores = new ArrayList<>(2); // Sets two stores for two players
        setUpPits();
        setUpStores();
        initializeBoard();
    }

    // Method, Captures stones from the opponent's pits.
    public int captureStones(int stoppingPoint) throws PitNotFoundException {
        stoppingPoint--; // Adjust stopping point to match the array index

        // Adding the logic to throw PitNotFoundException
        if (stoppingPoint < 0 || stoppingPoint >= pits.size()) {
            throw new PitNotFoundException("Invalid pit selection.");
        }

        int removed = pits.get(stoppingPoint).removeStones();
        int removeOpps = pits.get((12 - stoppingPoint) - 1).removeStones(); // Calculation to get the opposite pit
        int capturedStones = removeOpps + removed;

        if (knowPlayer == 1) {
            stores.get(0).addStones(capturedStones);
        } else if (knowPlayer == 2) {
            stores.get(1).addStones(capturedStones);
        }

        return capturedStones;
    }

    // Method, Helper method that distributes stones into pits and stores, skipping
    // the opponent's store.
    public int distributeStones(int startingPoint) throws PitNotFoundException {
        startingPoint--; // Adjust for starting index
        int stoneDistribute = pits.get(startingPoint).removeStones();
        int stoneAddedPit = stoneDistribute;
        int i = 0;

        // Loop to distribute stones into pits and stores
        for (i = startingPoint + 1; stoneDistribute > 0; i++) {
            i = i % pits.size(); // Will determine if the end of the list is reached

            // Check if the store can gain a stone, checks on the depending store of the
            // player
            if (currentPlayer == 0 && i == 6 || currentPlayer == 1 && i == 0) {
                stores.get(currentPlayer).addStones(1);
                stoneDistribute -= 1;
            }

            // Will check if the bonus is taken, will simply leave otherwise
            if (stoneDistribute == 0) {
                isBonus = true;
                break;
            } else {
                isBonus = false;
            }

            // Adds a stone to the current pit
            pits.get(i).addStone();
            stoneDistribute--;

            // Will check for taking stones from oponent
            if (stoneDistribute == 0) {
                break;
            }
        }

        try {
            // Checks if the capture is possible
            if ((currentPlayer == 0 && i >= 0 && i < 6
                    || currentPlayer == 1 && i >= 6 && i < 12)
                    && pits.get(i).getStoneCount() == 1) {
                knowPlayer = currentPlayer == 0 ? 1 : 2;
                captureStones(i + 1);
            }
        } catch (PitNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return stoneAddedPit;
    }

    // Method, Gets the number of stones in a specific pit.
    public int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum < 1 || pitNum > 12) {
            throw new PitNotFoundException("Invalid pit selection.");
        }
        return pits.get(pitNum - 1).getStoneCount();
    }

    // Method, Returns the list of pits in the board, not including the stores
    public ArrayList<Pit> getPits() {
        return pits;
    }

    // Method, Returns the list of stores in the board, not including the stores
    public ArrayList<Store> getStores() {
        return stores;
    }

    // Method, Initializes the board by distributing stones.
    public void initializeBoard() {
        for (Pit pit : pits) {
            pit.setPits();
        }
    }

    // Method, Indicates whether one side of the board is empty.
    public boolean isSideEmpty(int pitNum) throws PitNotFoundException {
        if (pitNum < 1 || pitNum > 12) {
            throw new PitNotFoundException("Invalid pit selection.");
        }

        // Will determine the range based on the pitNum (uses ternary operations)
        // Sets range 0 - 6 if <= 6, otherwise will set range to 6 - 12
        int start = (pitNum <= 6) ? 0 : 6;
        int end = (pitNum <= 6) ? 6 : 12;

        // Checks if any stones are present
        for (int i = start; i < end; i++) {
            if (pits.get(i).getStoneCount() != 0) {
                return false;
            }
        }
        return true;
    }

    // Method, Moves stones for the player starting from a specific pit.
    public int moveStones(int startPit, Player player) throws InvalidMoveException {
        startPit--; // Adjust to match index

        // Will determine which player it is dependent on the index
        int storeIndex = (player.getStore() == stores.get(0)) ? 0 : 1;
        int pitMin = storeIndex * 6; // Will calculate the minimum store index based on the players
        int pitMax = pitMin + 5; // Will calculate the maximum store index based on the player

        // Will check if it is within range
        if (startPit < pitMin || startPit > pitMax) {
            throw new InvalidMoveException("Invalid pit selection.");
        }

        currentPlayer = storeIndex; // Sets the player based on the storeIndex

        int previousValueOfStore = player.getStoreCount(); // Saves value

        try { // Will distribute the stones now from the starting pit
            distributeStones(startPit + 1);
        } catch (PitNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Gets the current store value of the player
        int currentValueOfStore = player.getStoreCount();
        // Finds the different and returns the value of the new store
        return currentValueOfStore - previousValueOfStore;
    }

    // Method, Connects Players to their Stores.
    public void registerPlayers(Player one, Player two) {
        stores.get(0).setOwner(one); // Sets the owner to the given params (p1)
        stores.get(1).setOwner(two); // Sets the owner to the given params (p2)

        two.setStore(stores.get(1)); // Sets the stores for p1
        one.setStore(stores.get(0)); // Sets the store for p2
    }

    // Method, Resets the board by redistributing stones but retains the players.
    public void resetBoard() {
        // Empties both stores
        for (int i = 0; i < 2; i++) {
            stores.get(i).emptyStore();
        }
        // Resets the board by creating a new one
        initializeBoard();
    }

    // Method, Establishes 12 empty Pits in the board
    public void setUpPits() {
        pits = new ArrayList<>(12); // Set initial capacity to 12
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
    }

    // Method, Establishes 2 empty Stores in the board
    public void setUpStores() {
        stores = new ArrayList<>(2); // Set initial capacity to 2
        stores.add(new Store());
        stores.add(new Store());
    }

    // Helper method, returns if bonus or not.
    public boolean isBonus() {
        return isBonus;
    }

    // Helper method, Gets the total amount of stones on one side of the board
    public int stoneTotalSide(int pitSide) {
        pitSide--; // Adjust to match array index
        int amount = 0;

        // Calculates total stones based on side
        int start = (pitSide >= 0 && pitSide < 6) ? 0 : 6;
        int end = (pitSide >= 0 && pitSide < 6) ? 6 : 12;

        for (int i = start; i < end; i++) {
            amount += pits.get(i).getStoneCount();
        }

        return amount;
    }

    // Partially generated by AI
    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();

        // Display pits 12 to 7 with pit numbers
        boardString.append("\t\t\t");
        for (int i = 12; i > 6; i--) {
            boardString.append(String.format("%2d:[%d] ", i, pits.get(i - 1).getStoneCount()));
        }

        // Display stones in player 2's store
        boardString.append("\n").append(stores.get(1).getOwner().getName()).append("'s Store: [")
                .append(stores.get(1).getTotalStones()).append("] | ");

        // Separator line
        boardString.append("\t-----------------------------------------------\t");

        // Display stones in player 1's store
        boardString.append(" | ").append(stores.get(0).getOwner().getName()).append("'s Store: [")
                .append(stores.get(0).getTotalStones()).append("]\n");

        // Display pits 1 to 6 with pit numbers
        boardString.append("\t\t\t");
        for (int i = 1; i <= 6; i++) {
            boardString.append(String.format("%2d:[%d] ", i, pits.get(i - 1).getStoneCount()));
        }

        return boardString.toString(); // Returns whole thing generated
    }
    // End of AI generation
}
