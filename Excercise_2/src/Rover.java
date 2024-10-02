public class Rover {
    private Position position;
    private Direction direction;
    private final Grid grid;

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() throws Exception {
        Position nextPosition = direction.moveForward(position);
        if (!grid.isPositionWithinBounds(nextPosition)) {
            throw new Exception("Rover is attempting to move out of bounds!");
        }
        if (grid.hasObstacle(nextPosition)) {
            throw new Exception("Obstacle detected! Cannot move to position: " + nextPosition);
        }
        this.position = nextPosition;
    }

    public void turnLeft() {
        this.direction = direction.turnLeft();
    }

    public void turnRight() {
        this.direction = direction.turnRight();
    }

    public String reportStatus() {
        return "Rover is at " + position + " facing " + direction + ".";
    }
}
