package uk.gov.dwp.maze;

import java.util.Scanner;

/**
 * Class to load and query a maze using the console.
 */
public class MazeLauncher {


    public static void main(String[] args) {
        System.out.println("Loaded default Maze");
        Maze maze = MazeLoader.loadDefaultMaze();
        Scanner scanny = new Scanner(System.in);
        printMenu();

        String currentInput = scanny.nextLine();
        do {
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
                String mazeResourceName = scanny.nextLine();
                maze = MazeLoader.loadMazeFromResource(mazeResourceName);
                System.out.println("Loaded " + mazeResourceName + "maze");
            }
            currentInput = scanny.nextLine();
        } while (!currentInput.equalsIgnoreCase("Q"));


    }

    public static void printMenu() {
        System.out.println("***");
        System.out.println("Welcome to MazeLauncher. Please choose one of the following options:");
        System.out.println("L - Load particular maze.");
        System.out.println("S - Show stats(total walls & total spaces)");
        System.out.println("? - Query particular X and Y coordinate");
        System.out.println("Q - Quit");
        System.out.println("***");
    }
}
