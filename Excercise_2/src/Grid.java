import java.util.*;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    private static Grid instance;

    private Grid(int width, int height, List<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>(obstacles);
    }

    public static Grid getInstance(int width, int height, List<Position> obstacles) {
        if (instance == null) {
            instance = new Grid(width, height, obstacles);
        }
        return instance;
    }

    public boolean isPositionWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height;
    }

    public boolean hasObstacle(Position position) {
        return obstacles.contains(position);
    }
}
