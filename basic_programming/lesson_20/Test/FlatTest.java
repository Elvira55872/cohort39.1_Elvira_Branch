import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FlatTest {

    @Test
    public void testSetRoomer() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");

        String[] expected1 = {"Kate", "Maria"};
        boolean expected2 = true;

        boolean result = Arrays.equals(flat.setRoomer("Maria"), expected1);

        Assertions.assertEquals(expected2, result);
    }

    @Test
    public void testRemoveRoomer() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");

        String[] expected1= new String[0];
        boolean expected2 = true;

        boolean result = Arrays.equals(flat.removeRoomer("Kate"), expected1);

        Assertions.assertEquals(expected2, result);
    }

    @Test
    public void testGetNumberOfFlat() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");

        int expected= 5;
        int result = flat.getNumberOfFlat();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetRoomers() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");

        String expected= "[Kate]";
        String result = flat.getRoomers();

        Assertions.assertEquals(expected, result);
    }
}
