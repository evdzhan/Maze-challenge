package uk.gov.dwp.maze.explorer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExplorerTest {

    private Explorer explorerUnderTest;

    @BeforeEach
    public void setup() {
        this.explorerUnderTest = new Explorer(new ExplorerLocation(0, 0));
    }

    @Test
    void getExplorerLocation_DefaultLocation() {
        assertEquals(0, explorerUnderTest.getExplorerLocation().getX());
        assertEquals(0, explorerUnderTest.getExplorerLocation().getY());
    }

    @Test
    void getExplorerLocation_MoveNorthGoesToMinusOneOnXAxis() {
        explorerUnderTest.moveForward();
        assertEquals(-1, explorerUnderTest.getExplorerLocation().getX());
        assertEquals(0, explorerUnderTest.getExplorerLocation().getY());
    }

    @Test
    void getExplorerLocation_MoveEastGoesPlusOneOnYAxis() {
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        assertEquals(0, explorerUnderTest.getExplorerLocation().getX());
        assertEquals(1, explorerUnderTest.getExplorerLocation().getY());
    }

    @Test
    void getExplorerLocation_MoveSouthGoesPlusOneOnXAxis() {
        explorerUnderTest.turnRight();
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        assertEquals(1, explorerUnderTest.getExplorerLocation().getX());
        assertEquals(0, explorerUnderTest.getExplorerLocation().getY());
    }

    @Test
    void getExplorerLocation_MoveWestGoesMinusOneOnYAxis() {
        explorerUnderTest.turnLeft();
        explorerUnderTest.moveForward();
        assertEquals(0, explorerUnderTest.getExplorerLocation().getX());
        assertEquals(-1, explorerUnderTest.getExplorerLocation().getY());
    }

    @Test
    void getExplorerLocationHistory_MoveFiveSouth() {
        explorerUnderTest.turnRight();
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        String history = explorerUnderTest.getExplorerLocationHistory();
        assertEquals("Explorer was at X:0 Y:0\n" +
                "Explorer was at X:1 Y:0\n" +
                "Explorer was at X:2 Y:0\n" +
                "Explorer was at X:3 Y:0\n" +
                "Explorer was at X:4 Y:0", history);
    }

    @Test
    void getExplorerLocationHistory_MoveFiveEast() {
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        String history = explorerUnderTest.getExplorerLocationHistory();
        assertEquals("Explorer was at X:0 Y:0\n" +
                "Explorer was at X:0 Y:1\n" +
                "Explorer was at X:0 Y:2\n" +
                "Explorer was at X:0 Y:3\n" +
                "Explorer was at X:0 Y:4", history);
    }

    @Test
    void getExplorerLocationHistory_MoveFiveEastThenMoveTwoSouth() {
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        String history = explorerUnderTest.getExplorerLocationHistory();
        assertEquals("Explorer was at X:0 Y:0\n" +
                "Explorer was at X:0 Y:1\n" +
                "Explorer was at X:0 Y:2\n" +
                "Explorer was at X:0 Y:3\n" +
                "Explorer was at X:0 Y:4\n" +
                "Explorer was at X:1 Y:4\n" +
                "Explorer was at X:2 Y:4", history);
    }

    @Test
    void getExplorerLocationHistory_MoveFiveEastThenMoveTwoSouthThenThreeWest() {
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.turnRight();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();
        explorerUnderTest.moveForward();

        String history = explorerUnderTest.getExplorerLocationHistory();
        assertEquals("Explorer was at X:0 Y:0\n" +
                "Explorer was at X:0 Y:1\n" +
                "Explorer was at X:0 Y:2\n" +
                "Explorer was at X:0 Y:3\n" +
                "Explorer was at X:0 Y:4\n" +
                "Explorer was at X:1 Y:4\n" +
                "Explorer was at X:2 Y:4\n" +
                "Explorer was at X:2 Y:3\n" +
                "Explorer was at X:2 Y:2\n" +
                "Explorer was at X:2 Y:1", history);
    }

}