package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board; // The game board
    private ArrayList<Player> players; // List of players
    private Player currentPlayer; // Current player making a move

    // Constructor, Initializes a new Mancala game.
    public MancalaGame() {
        board = new Board(); // Create a new game board
        players = new ArrayList<>(2); // Sets it to two, two player game
    }

    // Method, Gets the board for the game.
    public Board getBoard() {
        return board;
    }

    // Method, Gets the current player.
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    // Method, Gets the number of stones in a specific pit.
    public int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum < 1 || pitNum > board.getPits().size()) {
            throw new PitNotFoundException("Invalid pit selection.");
        }
        return board.getNumStones(pitNum);
    }

    // Method, Gets the players for the game.
    public ArrayList<Player> getPlayers() {
        return players;
    }

    // Method, Gets the total number of stones in a player's store.
    public int getStoreCount(Player player) throws NoSuchPlayerException {
        if (player == null || player.getStore() == null) {
            throw new NoSuchPlayerException("Player does not exist.");
        }
        return player.getStore().getTotalStones();
    }

    // Method, Gets the winner of the game.
    public Player getWinner() throws GameNotOverException {
        int playerOneStoreCount = 0;
        int playerTwoStoreCount = 0;

        try {
            // Calculate total stones
            playerOneStoreCount = getStoreCount(players.get(0)) + board.stoneTotalSide(2);
            playerTwoStoreCount = getStoreCount(players.get(1)) + board.stoneTotalSide(10);
        } catch (NoSuchPlayerException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Check if game over
        if (!isGameOver()) {
            throw new GameNotOverException("Game is not over.");
        } else {
            // Determine winner on stone store count
            if (playerOneStoreCount > playerTwoStoreCount) {
                return players.get(0);
            } else if (playerTwoStoreCount > playerOneStoreCount) {
                return players.get(1);
            }
            return null; // tie
        }
    }

    // Method, Checks if the game is over.
    public boolean isGameOver() {
        try {
            // Checks if either side of the baord is empty
            if (board.isSideEmpty(3) || board.isSideEmpty(8)) {
                return true;
            }
        } catch (PitNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

    // Method, Makes a move for the current player.
    public int move(int startPit) throws InvalidMoveException, PitNotFoundException {
        // Checks if game is over
        if (isGameOver()) {
            throw new InvalidMoveException("Game is over");
        }

        try {
            // Checks if the pit is empty
            if (board.getNumStones(startPit) == 0) {
                throw new InvalidMoveException("Selected pit is empty.");
            }
        } catch (PitNotFoundException e) { // If the pit is not found
            System.err.println("Error: " + e.getMessage());
            // Returns total amount of stones on side
            return board.stoneTotalSide(startPit);
        }

        try {
            // Moves the stones from selected pit
            board.moveStones(startPit, currentPlayer);
        } catch (InvalidMoveException e) {
            System.err.println("Error1: " + e.getMessage());
            return board.stoneTotalSide(startPit);
        }

        // Switches if there is no bonus
        switchPlayerIfNoBonus();

        // Returns total amount of stones on the side
        return board.stoneTotalSide(startPit);
    }

    // Method, Sets the board for the game.
    public void setBoard(Board theBoard) {
        board = theBoard;
    }

    // Method, sets the current player.
    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    // Method, Sets the players for the game.
    public void setPlayers(Player onePlayer, Player twoPlayer) {
        players.add(onePlayer); // sets player 1
        players.add(twoPlayer); // sets player 2

        board.registerPlayers(onePlayer, twoPlayer); // registers both players
        currentPlayer = players.get(0); // sets current player to player 1, first turn
    }

    // Method, Starts a new game by resetting the board.
    public void startNewGame() {
        board.resetBoard();
    }

    // Helper method, helps with move() function with checking if the bonus is
    // valid.
    private void switchPlayerIfNoBonus() {
        // Checks if the current player is the first player and there is no bonus move
        if (currentPlayer == players.get(0) && !board.isBonus()) {
            // Switches to second player
            currentPlayer = players.get(1);
            // Checks if the current player is the second player and there is no bonus move
        } else if (currentPlayer == players.get(1) && !board.isBonus()) {
            // Switches to the first player
            currentPlayer = players.get(0);
        }
    }

    // Method, Generates a string representation of the game.
    @Override
    public String toString() {
        return board.toString();
    }
}