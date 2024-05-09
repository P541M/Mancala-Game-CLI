package mancala;

public class Pit {
    private int stoneCount;

    public Pit() {
        this.stoneCount = 0;
    }

    public void addStone() {
        this.stoneCount++;
    }

    public int getStoneCount() {
        return this.stoneCount;
    }

    public int removeStones() {
        int removedStones = this.stoneCount;
        this.stoneCount = 0;
        return removedStones;
    }

    @Override
    public String toString() {
        return "Pit: " + this.stoneCount + " stone(s)";
    }
}