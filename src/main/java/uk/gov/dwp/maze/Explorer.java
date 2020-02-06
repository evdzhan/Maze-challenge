package uk.gov.dwp.maze;

import java.util.Stack;

public class Explorer {

    private Stack<ExplorerLocation> explorerLocations;
    private ExplorerDirection explorerDirection;

    public Explorer(ExplorerLocation initialLocation) {
        explorerLocations = new Stack<>();
        explorerLocations.push(initialLocation);
        explorerDirection = ExplorerDirection.NORTH;
    }

    public String toString() {
        return "Explorer is at X:" + explorerLocations.peek().getX() + " Y:" + explorerLocations.peek().getY() + "facing: "+ explorerDirection;
    }

}
