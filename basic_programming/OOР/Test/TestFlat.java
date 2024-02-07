
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestFlat {
    @Test
    public void testSetRoomer() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");
        flat.setRoomer("Maria");
        assertEquals(2, flat.countRoomers());
    }

    // тест на удаление жильца
    @Test
    public void testRemoveRoomer() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");
        flat.removeRoomer("Kate");
        assertEquals(0, flat.countRoomers());
    }

    // тест на получение номера квартиры
    @Test
    public void testGetNumberOfFlat() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");

        int expected = 5;
        int result = flat.getNumberOfFlat();

        assertEquals(expected, result);
    }

    // тест на получение имени жильца
    @Test
    public void testGetRoomers() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");

        String expected = "[Kate]";
        String result = flat.getRoomers();

        assertEquals(expected, result);
    }

    // тест на прекращение аренды
    @Test
    public void testTerminateRental() {
        Flat flat = new Flat(5, 40.0, 1, 2, "Kate");
        flat.terminateRental();

        assertEquals(2, flat.getRoomers().length());
    }

    // тест equals
    @Test
    public void testEquals() {
        Flat flat1 = new Flat(5, 40.0, 1, 2, "Kate");
        Flat flat2 = new Flat(5, 40.0, 1, 2, "Kate");
        Flat flat4 = new Flat(5, 5000.0, 1, 2, "Kate");
        Flat flat5 = new Flat(5, 40.0, 2, 2, "Kate");
        Flat flat6 = new Flat(5, 40.0, 1, 3, "Kate");
        Flat flat7 = new Flat(5, 40.0, 1, 2, "Maria");

        assertEquals(flat1, flat2);
        assertEquals(flat1, flat6);
        assertEquals(flat1, flat7);
        assertNotEquals(flat1, flat4);
        assertNotEquals(flat1, flat5);
    }
}
