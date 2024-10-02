public enum Direction {
    NORTH {
        @Override
        public Position moveForward(Position position) {
            return position.move(0, 1);
        }

        @Override
        public Direction turnLeft() {
            return WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }
    },
    EAST {
        @Override
        public Position moveForward(Position position) {
            return position.move(1, 0);
        }

        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Position moveForward(Position position) {
            return position.move(0, -1);
        }

        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }
    },
    WEST {
        @Override
        public Position moveForward(Position position) {
            return position.move(-1, 0);
        }

        @Override
        public Direction turnLeft() {
            return SOUTH;
        }

        @Override
        public Direction turnRight() {
            return NORTH;
        }
    };

    public abstract Position moveForward(Position position);
    public abstract Direction turnLeft();
    public abstract Direction turnRight();
}
