package Stacks;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
    @Test
    void pushTest() {
        MinStack stack = new MinStack();

        assertThrows(EmptyStackException.class, stack::min);

        stack.push(3);
        stack.push(2);
        stack.push(1);

        assertEquals(1, stack.min());
    }

    @Test
    void popTest() {
        MinStack stack = new MinStack();

        assertThrows(EmptyStackException.class, stack::min);

        stack.push(3);
        stack.push(2);
        stack.push(1);

        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.min());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.min());
    }

    @Test
    void minTest() {
        MinStack stack = new MinStack();
        stack.push(10);

        assertEquals(10, stack.min());

        stack.push(20);

        assertEquals(10, stack.min());

        stack.push(4);
        assertEquals(4, stack.min());
        stack.pop();

        assertEquals(10, stack.min());

        stack.push(1);

        assertEquals(1, stack.min());
        stack.push(123);
        assertEquals(1, stack.min());
    }

}