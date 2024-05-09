package mancala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class BoardTest {
    //captureStones not tested
    //resetBoard not tested

    private Board board = new Board();

    @Test
    void testSetUpStores() {
        board.setUpStores();
        assertEquals(2, board.getStores().size(), "The number of stores should be 2");
    }

    @Test
    void testInitializeBoard() {
        board.initializeBoard();
        int totalStones = 0;
        for (Pit pit : board.getPits()) {
            totalStones += pit.getStoneCount();
        }
        assertEquals(48, totalStones, "The total number of stones should be 48");
    }

    @Test
    void testSetUpPits() {
        board.setUpPits();
        assertEquals(12, board.getPits().size(), "The number of pits should be 12");
    }

    @Test
    void testDistributeStones() {
        int startingPoint = 1;
        try {
            int stoneAddedPit = board.distributeStones(startingPoint);
            assertEquals(4, stoneAddedPit, "The stone added to the pit should be 4");
        } catch (PitNotFoundException e) {
            fail("Pit not found");
        }
    }

    @Test
    void testGetNumStones() {
        int pitNum = 1;
        try {
            int numStones = board.getNumStones(pitNum);
            assertEquals(4, numStones, "The number of stones in the pit should be 4");
        } catch (PitNotFoundException e) {
            fail("Pit not found");
        }
    }

    @Test
    void testGetPits() {
        ArrayList<Pit> pits = board.getPits();
        assertEquals(12, pits.size(), "The number of pits should be 12");
    }

    @Test
    void testGetStores() {
        ArrayList<Store> stores = board.getStores();
        assertEquals(2, stores.size(), "The number of stores should be 2");
    }

    @Test
    void testIsSideEmpty() {
        int pitNum = 1;
        try {
            boolean isSideEmpty = board.isSideEmpty(pitNum);
            assertFalse(isSideEmpty, "The side should not be empty");
        } catch (PitNotFoundException e) {
            fail("Pit not found");
        }
    }

    @Test
    void testRegisterPlayers() {
        Player player1 = new Player("Jake");
        Player player2 = new Player("Dylan");
        board.registerPlayers(player1, player2);
        assertEquals(player1, board.getStores().get(0).getOwner(), "The owner of the first store should be Jake");
        assertEquals(player2, board.getStores().get(1).getOwner(), "The owner of the second store should be Dylan");
    }
}
