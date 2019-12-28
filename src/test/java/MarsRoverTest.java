import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    public void land() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Rule
    public ExpectedException exceptedException = ExpectedException.none();

    @Test
    public void landOut() {
        exceptedException.expect(IllegalArgumentException.class);
        exceptedException.expectMessage("x = 11 is bigger than Area's width 10");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 11, 5, Rover.SOUTH);
    }

    @Test
    public void forward() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.WEST);
        rover.forward();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("45W");
    }

    @Test
    public void turnLeft() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55N");
    }

    @Test
    public void turnRight() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.SOUTH);
        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55W");
    }

    @Test
    public void mission() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverController.excute(mission);
        assertThat(position).isEqualTo("66E");
    }

}
