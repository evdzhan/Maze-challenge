package uk.gov.dwp.maze;

import lombok.Value;

@Value
public class MazeComponent {
    MazeComponentType type;

    public String toString() {
        return type.toString();
    }
}
