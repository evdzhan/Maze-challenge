package uk.gov.dwp.maze.explorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Explorer {

    private Stack<ExplorerLocation> explorerLocations;
    private ExplorerDirection explorerDirection;

    public Explorer(ExplorerLocation initialLocation) {
        explorerLocations = new Stack<>();
        explorerLocations.push(initialLocation);
        explorerDirection = ExplorerDirection.NORTH;
    }

    public ExplorerLocation getExplorerLocation() {
        return explorerLocations.peek();
    }

    public ExplorerDirection getExplorerDirection() {
        return explorerDirection;
    }

    public String toString() {
        return "Explorer is at X:" + explorerLocations.peek().getX() + " Y:" + explorerLocations.peek().getY() + ". He/she is facing: " + explorerDirection;
    }

    public void moveForward() {
        ExplorerLocation currentLocation = explorerLocations.peek();
        switch (explorerDirection) {
            case NORTH: // x-1 y+0
                explorerLocations.push(new ExplorerLocation(currentLocation.getX() - 1, currentLocation.getY()));
                break;
            case EAST: //  x+0 y+1
                explorerLocations.push(new ExplorerLocation(currentLocation.getX(), currentLocation.getY() + 1));
                break;
            case SOUTH: // x+1 y+0
                explorerLocations.push(new ExplorerLocation(currentLocation.getX() + 1, currentLocation.getY()));
                break;
            case WEST: // x+0 y-0
                explorerLocations.push(new ExplorerLocation(currentLocation.getX(), currentLocation.getY() - 1));
                break;

        }
    }

    public void turnLeft() {
        switch (explorerDirection) {
            case NORTH:
                explorerDirection = ExplorerDirection.WEST;
                break;
            case EAST:
                explorerDirection = ExplorerDirection.NORTH;
                break;
            case SOUTH:
                explorerDirection = ExplorerDirection.EAST;
                break;
            case WEST:
                explorerDirection = ExplorerDirection.SOUTH;
                break;

        }
    }

    public void turnRight() {
        switch (explorerDirection) {
            case NORTH:
                explorerDirection = ExplorerDirection.EAST;
                break;
            case EAST:
                explorerDirection = ExplorerDirection.SOUTH;
                break;
            case SOUTH:
                explorerDirection = ExplorerDirection.WEST;
                break;
            case WEST:
                explorerDirection = ExplorerDirection.NORTH;
                break;

        }
    }

    public String getExplorerLocationHistory() {
        ArrayList<ExplorerLocation> reversedOrderOfLocations = new ArrayList<>(explorerLocations); // reverse and replay
        return reversedOrderOfLocations.stream()
                .map(l -> "Explorer was at X:" + l.getX() + " Y:" + l.getY())
                .collect(Collectors.joining("\n"));
    }
}
