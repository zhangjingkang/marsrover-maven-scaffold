public class RoverController {

    private Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String execute(String mission) {

        String[] command = mission.split(",");
        int areaWith = Integer.parseInt(command[0]);
        int areaHeight = Integer.parseInt(command[1]);
        Area area = new Area(areaWith, areaHeight);

        int x = Integer.parseInt(command[2]);
        int y = Integer.parseInt(command[3]);

        rover.land(area, x, y, command[4]);

        for (int i = 5; i < command.length; i++) {
            if ("L".equals(command[i])) {
                rover.turnLeft();
            }
            if ("R".equals(command[i])) {
                rover.turnRight();
            }
            if ("M".equals(command[i])) {
                rover.forward();
            }

        }
        return rover.getPosition();
    }
}
