package uk.gov.dwp.maze;

import lombok.Value;

@Value
public class Maze {

    final int wallsCount;
    final int spacesCount;
    final MazeComponent[][] mazeComponents;

    public Maze(MazeComponent[][] mazeComponents) {
        this.mazeComponents = mazeComponents;

        int _wallsCount = 0;
        int _spacesCount = 0;
        boolean startFound = false;
        boolean endFound = false;
        for (MazeComponent[] mazeComponent : mazeComponents) {
            for (MazeComponent currentComponent : mazeComponent) {
                switch (currentComponent.getType()) {
                    case WALL:
                        _wallsCount++;
                        break;
                    case EMPTY_SPACE:
                        _spacesCount++;
                        break;
                    case END:
                        if (endFound)
                            throw new IllegalArgumentException("The maze components contained more than one end positions");
                        else endFound = true;
                        break;
                    case START:
                        if (startFound)
                            throw new IllegalArgumentException("The maze components contained more than one start positions");
                        else startFound = true;
                        break;
                }
            }
        }
        this.wallsCount = _wallsCount;
        this.spacesCount = _spacesCount;
    }

    public String query(int x, int y) {
        if (x >= 0 && x < mazeComponents.length && y >= 0 && y < mazeComponents[x].length) {
            return mazeComponents[x][y].toString();
        } else {
            throw new IndexOutOfBoundsException("Out of bounds query.");
        }
    }
}
