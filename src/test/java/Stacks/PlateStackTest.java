package Stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateStackTest {

    @Test
    public void integratedTest() {
        PlateStack stack = new PlateStack(2);

        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(1, stack.getNumStacks());
        stack.push(4);
        assertEquals(4, stack.peek());

        stack.push(5);
        assertEquals(2, stack.getNumStacks());
        assertEquals(5, stack.peek());

        assertEquals(5, stack.pop());
        assertEquals(1, stack.getNumStacks());

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(0, stack.getNumStacks());
    }
}