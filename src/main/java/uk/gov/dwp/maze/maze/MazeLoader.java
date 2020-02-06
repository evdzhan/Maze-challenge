package uk.gov.dwp.maze.maze;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MazeLoader {

    public static final String DEFAULT_RESOURCE_NAME = "Maze1.txt";

    public static Maze loadDefaultMaze() {
        return loadMazeFromResource(DEFAULT_RESOURCE_NAME);
    }

    public static Maze loadMazeFromResource(String resourceName) {
        URL url = Resources.getResource(resourceName);
        try {
            List<String> resourceContents = Resources.readLines(url, StandardCharsets.UTF_8);
            MazeComponent[][] mazeComponentTwoDimensionalGrid = resourceAsMazeGrid(resourceContents);
            return new Maze(mazeComponentTwoDimensionalGrid);

        } catch (IOException e) {
            throw new IllegalStateException(String.format("Failed to load resource. " +
                    "Check that the resource: %s is below resources folder.", resourceName));
        }
    }

    private static MazeComponent[][] resourceAsMazeGrid(List<String> resourceContents) {
        MazeComponent[][] mazeComponents = new MazeComponent[resourceContents.size()][];

        for (int i = 0; i < resourceContents.size(); i++) {
            mazeComponents[i] = new MazeComponent[resourceContents.get(i).length()];
            for (int j = 0; j < resourceContents.get(i).length(); j++) {
                mazeComponents[i][j] = new MazeComponent(MazeComponentType.get(resourceContents.get(i).charAt(j)));
            }
        }
        return mazeComponents;

    }


}
