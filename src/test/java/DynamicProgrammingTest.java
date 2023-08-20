import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicProgrammingTest {

    @Test
    public void countStepTest() {
        DynamicProgramming dp = new DynamicProgramming();

        assertEquals(dp.tripleStep(0), 1);
        assertEquals(dp.tripleStep(1), 1);
        assertEquals(dp.tripleStep(2), 2);
        assertEquals(dp.tripleStep(3), 4);
        assertEquals(dp.tripleStep(4), 7);
        assertEquals(dp.tripleStep(5), 13);
    }
}
