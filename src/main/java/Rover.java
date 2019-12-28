public class Rover {

    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";

    private int x;
    private int y;
    private Area landArea;
    private String direction;

    public void land(Area area, int x, int y, String direction) {
        if (x > area.getX()) {
            throw new IllegalArgumentException("x = " + x + " is bigger than Area's width " + area.getX());
        }
        if (y > area.getY()) {
            throw new IllegalArgumentException("y = " + y + " is bigger than Area's height " + area.getY());
        }

        this.landArea = area;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getPosition() {
        return "" + x + y + direction;
    }

    public void forward() {
        if ("E".equals(this.direction)) {
            x++;
        }
        if ("W".equals(this.direction)) {
            x--;
        }
        if ("N".equals(this.direction)) {
            y++;
        }
        if ("S".equals(this.direction)) {
            y--;
        }
    }

    public void turnLeft() {
        if ("E".equals(this.direction)) {
            direction = Rover.NORTH;
        } else if ("W".equals(this.direction)) {
            direction = Rover.SOUTH;
        } else if ("N".equals(this.direction)) {
            direction = Rover.WEST;
        } else if ("S".equals(this.direction)) {
            direction = Rover.EAST;
        }
    }

    public void turnRight() {
        if ("E".equals(this.direction)) {
            direction = Rover.SOUTH;
        } else if ("W".equals(this.direction)) {
            direction = Rover.NORTH;
        } else if ("N".equals(this.direction)) {
            direction = Rover.EAST;
        } else if ("S".equals(this.direction)) {
            direction = Rover.WEST;
        }
    }

}
