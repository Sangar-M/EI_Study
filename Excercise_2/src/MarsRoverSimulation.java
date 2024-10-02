import java.util.*;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get grid size
            System.out.print("Enter grid width: ");
            int width = scanner.nextInt();
            System.out.print("Enter grid height: ");
            int height = scanner.nextInt();

            // Get starting position of the Rover
            System.out.print("Enter Rover's starting X position: ");
            int startX = scanner.nextInt();
            System.out.print("Enter Rover's starting Y position: ");
            int startY = scanner.nextInt();
            System.out.print("Enter Rover's starting direction (N, S, E, W): ");
            String directionInput = scanner.next().toUpperCase();

            // Map single letter input to Direction enum
            Direction startDirection = mapDirection(directionInput);

            if (startDirection == null) {
                System.out.println("Invalid direction input. Please enter N, S, E, or W.");
                return;
            }

            // Get obstacles
            System.out.print("How many obstacles would you like to add? ");
            int obstacleCount = scanner.nextInt();
            List<Position> obstacles = new ArrayList<>();
            for (int i = 0; i < obstacleCount; i++) {
                System.out.print("Enter obstacle " + (i + 1) + " X position: ");
                int obstacleX = scanner.nextInt();
                System.out.print("Enter obstacle " + (i + 1) + " Y position: ");
                int obstacleY = scanner.nextInt();
                obstacles.add(new Position(obstacleX, obstacleY));
            }

            // Initialize grid with the size and obstacles
            Grid grid = Grid.getInstance(width, height, obstacles);

            // Initialize the rover with the starting position and direction
            Rover rover = new Rover(new Position(startX, startY), startDirection, grid);

            // Get the command sequence from the user
            System.out.print("Enter command sequence (M for move, L for left, R for right) separated by spaces: ");
            scanner.nextLine(); // Consume the leftover newline
            String commandsInput = scanner.nextLine().toUpperCase();

            // Split the input into individual commands
            String[] commands = commandsInput.split(" ");

            // Execute each command in sequence
            for (String cmd : commands) {
                switch (cmd) {
                    case "M":
                        new MoveCommand(rover).execute();
                        break;
                    case "L":
                        new TurnLeftCommand(rover).execute();
                        break;
                    case "R":
                        new TurnRightCommand(rover).execute();
                        break;
                    default:
                        System.out.println("Invalid command: " + cmd);
                }
            }

            // Get the rover's final status
            System.out.println(rover.reportStatus());

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Helper method to map single-letter directions to enum values
    private static Direction mapDirection(String input) {
        switch (input) {
            case "N":
                return Direction.NORTH;
            case "S":
                return Direction.SOUTH;
            case "E":
                return Direction.EAST;
            case "W":
                return Direction.WEST;
            default:
                return null;  // Return null if the input is invalid
        }
    }
}
