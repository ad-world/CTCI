package Stacks;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    public void pushTest() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        assertEquals(1, queue.peek());

        queue.push(2);
        assertEquals(1, queue.peek());

        queue.push(3);
        assertEquals(1, queue.peek());
    }

    @Test
    public void popTest() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        assertEquals(1, queue.peek());

        queue.push(2);
        assertEquals(1, queue.peek());

        queue.push(3);
        assertEquals(1, queue.peek());

        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
        assertThrows(EmptyStackException.class, queue::pop);
        assertThrows(EmptyStackException.class, queue::peek);
    }

}