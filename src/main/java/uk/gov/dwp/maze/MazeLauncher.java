package uk.gov.dwp.maze;

import uk.gov.dwp.maze.explorer.Explorer;
import uk.gov.dwp.maze.explorer.ExplorerDirection;
import uk.gov.dwp.maze.explorer.ExplorerLocation;
import uk.gov.dwp.maze.maze.Maze;
import uk.gov.dwp.maze.maze.MazeComponentType;
import uk.gov.dwp.maze.maze.MazeLoader;

import java.util.Scanner;

/**
 * Class to load and query a maze using the console.
 */
public class MazeLauncher {

    static final Scanner scanny = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Loaded default Maze");
        Maze maze = MazeLoader.loadDefaultMaze();
        printMenu();
        runMainMenu(maze);
    }

    private static void runMainMenu(Maze maze) {
        while (true) {
            String currentInput = scanny.nextLine();
            if (currentInput.equalsIgnoreCase("S")) {
                System.out.println("Available spaces: " + maze.getSpacesCount());
                System.out.println("Total walls: " + maze.getWallsCount());
            } else if (currentInput.equalsIgnoreCase("?")) {
                System.out.println("Enter x coordinate:");
                int x = scanny.nextInt();
                System.out.println("Enter y coordinate:");
                int y = scanny.nextInt();
                System.out.println(maze.query(x, y).toString());
            } else if (currentInput.equalsIgnoreCase("L")) {
                System.out.println("Please enter the name of the Maze file. This should be found below the resources \n" +
                        "folder and be a .txt file containing 2D representation of the maze, where 'X' denotes wall\n" +
                        " and empty space denotes walkable terrain. 'F' represents finish, while 'S' represents start.\n" +
                        " (Press enter to load default maze).");
                String mazeResourceName = scanny.nextLine();
                if (mazeResourceName.equalsIgnoreCase("")) {
                    maze = MazeLoader.loadDefaultMaze();
                    System.out.println("Loaded default maze.");
                } else {
                    maze = MazeLoader.loadMazeFromResource(mazeResourceName);
                    System.out.println("Loaded " + mazeResourceName + " maze file successfully.");
                }
            } else if (currentInput.equalsIgnoreCase("E")) {
                System.out.println("Switching to explorer menu.");
                runExplorerMenu(maze);
                System.out.println("Exited from explorer menu.");
                printMenu();
            } else if (currentInput.equalsIgnoreCase("Q")) {
                break;
            }
        }
    }

    private static void runExplorerMenu(Maze maze) {
        printExplorerMenu();
        Explorer explorer = new Explorer(new ExplorerLocation(maze.getStartX(), maze.getStartY()));
        while (true) {
            System.out.println(explorer.toString());
            System.out.println("Front of explorer is:" + queryFrontOfExplorer(explorer, maze));

            String currentInput = scanny.nextLine();
            if (currentInput.equalsIgnoreCase("P")) {
                System.out.println(explorer.toString());
            } else if (currentInput.equalsIgnoreCase("?")) {
                System.out.println("Front of explorer is: " + queryFrontOfExplorer(explorer, maze));
            } else if (currentInput.equalsIgnoreCase("M")) {
                if (!queryFrontOfExplorer(explorer, maze).equals(MazeComponentType.WALL)) {
                    explorer.moveForward();
                    System.out.println("Moved forward");
                } else {
                    System.out.println("Attempted to move into a wall, and failed. Preserved position.");
                }
            } else if (currentInput.equalsIgnoreCase("L")) {
                explorer.turnLeft();
            } else if (currentInput.equalsIgnoreCase("R")) {
                explorer.turnRight();
            } else if (currentInput.equalsIgnoreCase("V")) {
                System.out.println(queryAllPossibleDirectionsForExplorer(explorer, maze));
            } else if (currentInput.equalsIgnoreCase("H")) {
                System.out.println(explorer.getExplorerLocationHistory());
            } else if (currentInput.equalsIgnoreCase("Q")) {
                break;
            }
        }
    }

    private static String queryAllPossibleDirectionsForExplorer(Explorer explorer, Maze maze) {
        ExplorerLocation explorerLocation = explorer.getExplorerLocation();
        MazeComponentType queryNorth = maze.query(explorerLocation.getX() - 1, explorerLocation.getY());
        MazeComponentType queryEast = maze.query(explorerLocation.getX(), explorerLocation.getY() + 1);
        MazeComponentType querySouth = maze.query(explorerLocation.getX() + 1, explorerLocation.getY());
        MazeComponentType queryWest = maze.query(explorerLocation.getX(), explorerLocation.getY() - 1);
        return String.format("Explorer is facing a %s on the north. He/she %s legally move there.\n" +
                        "Explorer is facing a %s on the east. He/she %s legally move there.\n" +
                        "Explorer is facing a %s on the south. He/she %s legally move there.\n" +
                        "Explorer is facing a %s on the west. He/she %s legally move there.",
                queryNorth.toString(), !queryNorth.equals(MazeComponentType.WALL) ? "can" : "cannot",
                queryEast.toString(), !queryEast.equals(MazeComponentType.WALL) ? "can" : "cannot",
                querySouth.toString(), !querySouth.equals(MazeComponentType.WALL) ? "can" : "cannot",
                queryWest.toString(), !queryWest.equals(MazeComponentType.WALL) ? "can" : "cannot");
    }

    private static MazeComponentType queryFrontOfExplorer(Explorer explorer, Maze maze) {
        ExplorerLocation explorerLocation = explorer.getExplorerLocation();
        ExplorerDirection explorerDirection = explorer.getExplorerDirection();
        int attemptedXMove = -1;
        int attemptedYMove = -1;
        switch (explorerDirection) {
            case NORTH:
                attemptedXMove = explorerLocation.getX() - 1;
                attemptedYMove = explorerLocation.getY();
                break;
            case EAST:
                attemptedXMove = explorerLocation.getX();
                attemptedYMove = explorerLocation.getY() + 1;
                break;
            case SOUTH:
                attemptedXMove = explorerLocation.getX() + 1;
                attemptedYMove = explorerLocation.getY();
                break;
            case WEST:
                attemptedXMove = explorerLocation.getX();
                attemptedYMove = explorerLocation.getY() - 1;
                break;
        }
        return maze.query(attemptedXMove, attemptedYMove);
    }

    public static void printMenu() {
        System.out.println("***");
        System.out.println("Welcome to MazeLauncher. Please choose one of the following options:");
        System.out.println("L - Load particular maze.");
        System.out.println("S - Show stats(total walls & total spaces)");
        System.out.println("? - Query particular X and Y coordinate");
        System.out.println("E - Drop explorer at current maze start position. This will switch to another interactive menu.");
        System.out.println("Q - Quit");
        System.out.println("***");
    }

    public static void printExplorerMenu() {
        System.out.println("***");
        System.out.println("Welcome to Maze Explorer. Please choose one of the following options:");
        System.out.println("P - Show current position.");
        System.out.println("? - Declare whats in front of the explorer");
        System.out.println("M - Move forward");
        System.out.println("L - Turn left");
        System.out.println("R - Turn right");
        System.out.println("V - Show all valid moves");
        System.out.println("H - All previous coordinates in historical order.");
        System.out.println("***");
    }
}
