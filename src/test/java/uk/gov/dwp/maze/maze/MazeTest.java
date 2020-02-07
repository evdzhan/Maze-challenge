package uk.gov.dwp.maze.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    public void testConstructMazeWithNullComponents() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Maze(null));
        assertEquals("mazeComponents is null", exception.getMessage());
    }

    @Test
    public void testConstructMazeWithValidComponents() {
        MazeComponent[][] mazeComponents = {
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.START),
                        new MazeComponent(MazeComponentType.EMPTY_SPACE),
                        new MazeComponent(MazeComponentType.END),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                }
        };

        new Maze(mazeComponents);
    }

    @Test
    public void testConstructMazeWithInValidComponentsNoStartPresent() {
        MazeComponent[][] mazeComponents = {
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.EMPTY_SPACE),
                        new MazeComponent(MazeComponentType.EMPTY_SPACE),
                        new MazeComponent(MazeComponentType.END),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                }
        };

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Maze(mazeComponents));
        assertEquals("The maze components contained no start position", exception.getMessage());
    }

    @Test
    public void testConstructMazeWithInValidComponentsNoEndPresent() {
        MazeComponent[][] mazeComponents = {
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.START),
                        new MazeComponent(MazeComponentType.EMPTY_SPACE),
                        new MazeComponent(MazeComponentType.EMPTY_SPACE),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                }
        };

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Maze(mazeComponents));
        assertEquals("The maze components contained no end position", exception.getMessage());
    }

    @Test
    public void testConstructMazeWithInValidComponentsTwoEndsPresent() {
        MazeComponent[][] mazeComponents = {
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.START),
                        new MazeComponent(MazeComponentType.END),
                        new MazeComponent(MazeComponentType.END),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                }
        };

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Maze(mazeComponents));
        assertEquals("The maze components contained more than one end positions", exception.getMessage());
    }

    @Test
    public void testConstructMazeWithInValidComponentsTwoStartsPresent() {
        MazeComponent[][] mazeComponents = {
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.START),
                        new MazeComponent(MazeComponentType.START),
                        new MazeComponent(MazeComponentType.END),
                        new MazeComponent(MazeComponentType.WALL),
                },
                {
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                        new MazeComponent(MazeComponentType.WALL),
                }
        };

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Maze(mazeComponents));
        assertEquals("The maze components contained more than one start positions", exception.getMessage());
    }
}