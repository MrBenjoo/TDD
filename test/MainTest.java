import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testFindMax1() {
        assertEquals(4, Main.findMax(new int[]{1,3,4,2}));
    }

    @Test
    public void testFindMax2() {
        assertEquals(-1, Main.findMax(new int[]{-12,-1,-3,-4}));
    }
}