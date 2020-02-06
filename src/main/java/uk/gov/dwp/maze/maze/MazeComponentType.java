package uk.gov.dwp.maze.maze;

import java.util.HashMap;
import java.util.Map;

/**
 * MazeComponent type enum. Can parse char and turn it into MazeComponentType.
 * <p>
 * Can deal with WALL('X' or 'x'), EMPTY_SPACE(' '), START('S' or 's'), END('F' or 'f').
 */
public enum MazeComponentType {
    WALL('X'),
    EMPTY_SPACE(' '),
    START('S'),
    END('F');

    private char charRepresentation;

    MazeComponentType(char c) {
        this.charRepresentation = Character.toUpperCase(c);
    }

    private static final Map<Character, MazeComponentType> lookup = new HashMap<>();

    static {
        for (MazeComponentType type : MazeComponentType.values()) {
            lookup.put(type.charRepresentation, type);
        }
    }

    public static MazeComponentType get(char type) {
        if (type != 'X' && type != 'x' && type != ' ' && type != 'S' && type != 's' && type != 'F' && type != 'f') {
            throw new IllegalArgumentException(String.format(
                    "Tried to parse char that is not know to the MazeComponentType. Was passed: '%s'.", type));
        }
        return lookup.get(Character.toUpperCase(type));
    }
}
