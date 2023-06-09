package Stacks;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class ThreeInOneTest {
    ThreeInOne stack = new ThreeInOne(10);

    @Test
    public void pushAndPeekTest() {
        ThreeInOne stack = new ThreeInOne(10);
        stack.push(0, 5);
        stack.push(1, 10);
        stack.push(2, 15);

        assertEquals(5, stack.peek(0));
        assertEquals(10, stack.peek(1));
        assertEquals(15, stack.peek(2));
    }

    @Test
    public void popTest() {
        ThreeInOne stack = new ThreeInOne(10);
        stack.push(0, 5);
        stack.push(1, 10);
        stack.push(2, 15);

        assertEquals(5, stack.pop(0));
        assertEquals(10, stack.pop(1));
        assertEquals(15, stack.pop(2));

        assertThrows(NoSuchElementException.class, () -> stack.pop(0));
        assertThrows(NoSuchElementException.class, () -> stack.pop(1));
        assertThrows(NoSuchElementException.class, () -> stack.pop(2));
    }

    @Test
    public void isEmptyTest() {
        ThreeInOne stack = new ThreeInOne(10);
        stack.push(0, 5);
        stack.push(1, 10);
        stack.push(2, 15);

        assertEquals(5, stack.pop(0));
        assertEquals(10, stack.pop(1));
        assertEquals(15, stack.pop(2));

        assertThrows(NoSuchElementException.class, () -> stack.pop(0));
        assertThrows(NoSuchElementException.class, () -> stack.pop(1));
        assertThrows(NoSuchElementException.class, () -> stack.pop(2));

        assertTrue(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertTrue(stack.isEmpty(2));

        stack.push(1, 2);
        assertFalse(stack.isEmpty(1));
    }
}