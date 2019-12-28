import Area.Area;
import Rover.Rover;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRover {
    @Test
    public void test() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }
}
