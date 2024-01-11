package lesson21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RobotTest {

    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = new Robot(5, 5);
    }

    @Test
    void testInitialPosition() {
        robot.setPosition(0, 0, 'N');
        assertEquals("Robot position: (0, 0) facing N", robot.toString());
    }

    @Test
    void testMoveForward() {
        robot.setPosition(2, 2, 'N');
        robot.processCommands("M");
        assertEquals("Robot position: (2, 3) facing N", robot.toString());
    }

    @Test
    void testTurnLeft() {
        robot.setPosition(2, 2, 'N');
        robot.processCommands("L");
        assertEquals("Robot position: (2, 2) facing W", robot.toString());
    }

    @Test
    void testTurnRight() {
        robot.setPosition(2, 2, 'N');
        robot.processCommands("R");
        assertEquals("Robot position: (2, 2) facing E", robot.toString());
    }

    @Test
    void testComplexCommands() {
        robot.setPosition(1, 2, 'N');
        robot.processCommands("LMLMLMLMM");
        assertEquals("Robot position: (1, 3) facing N", robot.toString());
    }

    @Test
    void testBoundaryConditions() {
        robot.setPosition(0, 0, 'W');
        robot.processCommands("MM");
        assertEquals("Robot position: (0, 0) facing W", robot.toString());
    }

    @Test
    void testInvalidPosition() {
        robot.setPosition(-1, 6, 'N');
        assertEquals("Robot position: (0, 0) facing N", robot.toString()); // Предполагаем, что начальная позиция не изменится
    }
}

