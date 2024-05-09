package ui;

import mancala.Player;
import mancala.MancalaGame;
import mancala.InvalidMoveException;
import mancala.PitNotFoundException;
import mancala.GameNotOverException;

import java.util.Scanner;

public class TextUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create players
        Player player1 = createPlayer(scanner, 1);
        Player player2 = createPlayer(scanner, 2);

        // Create Mancala game
        MancalaGame game = new MancalaGame();
        game.setPlayers(player1, player2);

        // Run the game
        while (!game.isGameOver()) {
            System.out.println(game);

            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("Current Player: " + currentPlayer.getName());

            try {
                System.out.print("Enter the pit number to make a move: ");
                int pitNumber = scanner.nextInt();

                int stonesMoved = game.move(pitNumber);

            } catch (InvalidMoveException | PitNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        // Print the final state of the game
        System.out.println("Game Over!");
        System.out.println(game);

        // Determine the winner
        try {
            Player winner = game.getWinner();
            if (winner != null) {
                System.out.println("The winner is: " + winner.getName());
            } else {
                System.out.println("It's a tie!");
            }
        } catch (GameNotOverException e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static Player createPlayer(Scanner scanner, int playerNumber) {
        System.out.print("Enter the name for Player " + playerNumber + ": ");
        String playerName = scanner.next();
        return new Player(playerName);
    }
}

