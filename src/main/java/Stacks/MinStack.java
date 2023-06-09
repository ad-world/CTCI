package Stacks;

import java.util.EmptyStackException;

public class MinStack {
    private static class StackNode {
        private final int data;
        private final int minimumOfSubstack;
        private StackNode next;

        private StackNode(int data, int currentMin) {
            this.data = data;
            minimumOfSubstack = Math.min(currentMin, data);
        }
    }

    private StackNode top;
    private int minimum = Integer.MAX_VALUE;

    public int pop() throws EmptyStackException {
        if(top == null) throw new EmptyStackException();

        int data = top.data;

        top = top.next;

        if(data == minimum) {
            minimum = top.minimumOfSubstack;
        }

        return data;
    }

    public int min() throws EmptyStackException {
        if(top == null) throw new EmptyStackException();

        return minimum;
    }

    public void push(int data) {
        minimum = Math.min(data, minimum);

        StackNode node = new StackNode(data, minimum);
        node.next = top;
        top = node;
    }
}
