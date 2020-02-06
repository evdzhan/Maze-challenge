package uk.gov.dwp.maze.maze;

import lombok.Value;

@Value
public class MazeComponent {
    MazeComponentType type;

    public String toString() {
        return type.toString();
    }
}
