package uk.gov.dwp.maze;

import uk.gov.dwp.maze.explorer.Explorer;
import uk.gov.dwp.maze.explorer.ExplorerLocation;
import uk.gov.dwp.maze.maze.Maze;
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
                System.out.println(maze.query(x, y));
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
                switchToExplorerMenu(maze);
                System.out.println("Exited from explorer menu.");
                printMenu();
            } else if (currentInput.equalsIgnoreCase("Q")) {
                break;
            }
        }


    }

    private static void switchToExplorerMenu(Maze maze) {
        printExplorerMenu();
        Explorer explorer = new Explorer(new ExplorerLocation(maze.getStartX(), maze.getStartY()));
        while (true) {
            String currentInput = scanny.nextLine();
            if (currentInput.equalsIgnoreCase("P")) {
                System.out.println(explorer.toString());
            } else if (currentInput.equalsIgnoreCase("?")) {

            } else if (currentInput.equalsIgnoreCase("L")) {

            } else if (currentInput.equalsIgnoreCase("Q")) {
                break;
            }
        }
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
        System.out.println("M - Move forward");
        System.out.println("L - Turn left");
        System.out.println("R - Turn right");
        System.out.println("S - Declare whats in front of the explorer");
        System.out.println("V - Show all valid moves");
        System.out.println("H - All previous coordinates in historical order.");
        System.out.println("***");
    }
}
