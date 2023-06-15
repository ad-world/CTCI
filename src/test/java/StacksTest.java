import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StacksTest {
    @Test
    public void sortTest() {
        Stacks stackProblems = new Stacks();

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(4);

        stackProblems.sort(s);

        assertEquals(1, s.pop());
        assertEquals(1, s.pop());
        assertEquals(2, s.pop());
        assertEquals(2, s.pop());
        assertEquals(3, s.pop());
        assertEquals(4, s.pop());
    }

}