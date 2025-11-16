class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction xDirection = (toX >= robot.getX()) ? Direction.RIGHT : Direction.LEFT;
        rotateRobotToDirection(robot.getDirection(), xDirection, robot);
        while (robot.getX() != toX) {
            robot.stepForward();
        }
        Direction yDirection = (toY >= robot.getY()) ? Direction.UP : Direction.DOWN;
        rotateRobotToDirection(robot.getDirection(), yDirection, robot);
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }

    private static void rotateRobotToDirection(Direction fromDirection, Direction toDirection, Robot robot) {
        String rotateDirection = rotateDirection(fromDirection, toDirection);
        if (rotateDirection == null) { // поворот не требуется
            return;
        }
        if ("right".equals(rotateDirection)) {
            while (robot.getDirection() != toDirection) {
                robot.turnRight();
            }
        } else {
            while (robot.getDirection() != toDirection) {
                robot.turnLeft();
            }
        }
    }

    private static String rotateDirection(Direction fromDirection, Direction toDirection) {
        if (fromDirection == toDirection) {
            return null;
        }
        Direction[] directions = {Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT};
        int fromIndex = -1;
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == fromDirection) {
                fromIndex = i;
                break;
            }
        }
        int nextRightDirectionIndex = (fromIndex + 1 < directions.length) ? fromIndex + 1 : 0;
        if (directions[nextRightDirectionIndex] == toDirection) {
            return "right";
        } else {
            return "left";
        }
    }


}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Testus {
    public static void main(String[] args) {
        Robot robot = new Robot(4, 5, Direction.UP);
        Move.moveRobot(robot, -7, 3);
        System.out.println(String.format("x: %d, y: %d", robot.getX(), robot.getY()));
    }
}