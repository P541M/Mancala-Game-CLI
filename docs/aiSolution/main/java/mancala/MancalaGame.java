package mancala;

import java.util.ArrayList;

public class MancalaGame {

    private ArrayList<Player> players;
    private Player currentPlayer;
    private Board board;

    // Constructor
    public MancalaGame() {
        this.players = new ArrayList<>();
        this.currentPlayer = null;
        this.board = null;
    }

    // Method to set players for the game
    public void setPlayers(Player onePlayer, Player twoPlayer) {
        // Implementation to set players for the game
        // ...
    }

    // Method to get the players for the game
    public ArrayList<Player> getPlayers() {
        // Implementation to return the list of players
        // ...
        return players;
    }

    // Method to get the current player
    public Player getCurrentPlayer() {
        // Implementation to return the current player
        // ...
        return currentPlayer;
    }

    // Method to set the current player
    public void setCurrentPlayer(Player player) {
        // Implementation to set the current player
        // ...
    }

    // Method to set the board for the game
    public void setBoard(Board theBoard) {
        // Implementation to set the board for the game
        // ...
    }

    // Method to get the board for the game
    public Board getBoard() {
        // Implementation to return the board for the game
        // ...
        return board;
    }

    // Method to get the number of stones in a specific pit
    public int getNumStones(int pitNum) throws PitNotFoundException {
        // Implementation to get the number of stones in a specific pit
        // ...
        return 0;
    }

    // Method to make a move for the current player
    public int move(int startPit) throws InvalidMoveException, IllegalStateException {
        // Implementation to make a move for the current player
        // ...
        return 0;
    }

    // Method to get the total number of stones in a player's store
    public int getStoreCount(Player player) throws NoSuchPlayerException {
        // Implementation to get the total number of stones in a player's store
        // ...
        return 0;
    }

    // Method to get the winner of the game
    public Player getWinner() throws GameNotOverException {
        // Implementation to get the winner of the game
        // ...
        return null;
    }

    // Method to check if the game is over
    public boolean isGameOver() {
        // Implementation to check if the game is over
        // ...
        return false;
    }

    // Method to start a new game by resetting the board
    public void startNewGame() {
        // Implementation to start a new game by resetting the board
        // ...
    }

    // Override toString method
    @Override
    public String toString() {
        // Implementation for the toString method
        // ...
        return super.toString();
    }
}
