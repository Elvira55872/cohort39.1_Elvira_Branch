package consultation2024_02_08.teachers_sandbox;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FindEvenIndexTests {

    @Test
    public void testSimple() {
        assertEquals(3, FindEvenIndex.findEvenIndex(new int[]{1,2,3,4,3,2,1}));
        assertEquals(1, FindEvenIndex.findEvenIndex(new int[]{1,100,50,-51,1,1}));
        assertEquals(0, FindEvenIndex.findEvenIndex(new int[]{20,10,-80,10,10,15,35}));
        assertEquals(-1, FindEvenIndex.findEvenIndex(new int[]{1,2,3,4,5,6}));
        assertEquals(0, FindEvenIndex.findEvenIndex(new int[]{0,0,0,0,0}));
        assertEquals(-1, FindEvenIndex.findEvenIndex(new int[]{-1,-2,-3,-4,-3,-2,-1}));
        assertEquals(6, FindEvenIndex.findEvenIndex(new int[]{1,2,3,4,5,6,7,-20}));
    }

    @Test
    public void testEmptyAndSingleElement() {
        assertEquals(0, FindEvenIndex.findEvenIndex(new int[]{0}));
        assertEquals(-1, FindEvenIndex.findEvenIndex(new int[]{}));
    }
}

