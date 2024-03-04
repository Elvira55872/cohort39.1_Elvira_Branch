import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    /**
     * 255, 255, 255 --> "FFFFFF"
     * 255, 255, 300 --> "FFFFFF"
     * 0, 0, 0       --> "000000"
     * 148, 0, 211   --> "9400D3"
     */

    @Test
    public void testCorrectData() {
        Assertions.assertEquals("9400D3", Main.rgb(148, 0, 211));
    }

    @Test
    public void testSideData() {
        Assertions.assertEquals("FFFFFF", Main.rgb(255, 255, 255));
        Assertions.assertEquals("000000", Main.rgb(0, 0, 0));
    }

    @Test
    public void testLargerThen255Data() {
        Assertions.assertEquals("FFFFFF", Main.rgb(3425, 3435, 7564));
        Assertions.assertEquals("FFFFFF", Main.rgb(256, 256, 256));
    }

    @Test
    public void testSmallerThen0Data() {
        Assertions.assertEquals("000000", Main.rgb(-43, -3212, -7564));
        Assertions.assertEquals("000000", Main.rgb(-1, -1, -1));
    }
}
