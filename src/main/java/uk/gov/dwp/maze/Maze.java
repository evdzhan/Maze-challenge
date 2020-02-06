package uk.gov.dwp.maze;

import lombok.Value;

@Value
public class Maze {

    final int wallsCount;
    final int spacesCount;
    final int startX;
    final int startY;
    final MazeComponent[][] mazeComponents;

    public Maze(MazeComponent[][] mazeComponents) {
        this.mazeComponents = mazeComponents;

        int _wallsCount = 0;
        int _spacesCount = 0;
        int _startX = -1;
        int _startY = -1;
        boolean startFound = false;
        boolean endFound = false;
        for (int i = 0; i < mazeComponents.length; i++) {
            for (int j = 0; j < mazeComponents[i].length; j++) {
                switch (mazeComponents[i][j].getType()) {
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
                        _startX = i;
                        _startY = j;
                        break;
                }
            }
        }
        if (!endFound)
            throw new IllegalArgumentException("The maze components contained no end position");

        if (!startFound)
            throw new IllegalArgumentException("The maze components contained no start position");

        this.startX = _startX;
        this.startY = _startY;
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
