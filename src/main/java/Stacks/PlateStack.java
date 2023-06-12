package Stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class PlateStack {

    private static class CustomStack<T> {
        private static class StackNode<T> {
            private final T data;
            private StackNode<T> next;

            private StackNode(T data) {
                this.data = data;
            }
        }


        private StackNode<T> top;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }

        public void push(T item) {
            StackNode<T> t = new StackNode<T>(item);
            t.next = top;
            top = t;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    private int numStacks;
    private final ArrayList<CustomStack<Integer>> stacks;
    private final int stackSize;

    private int currentStackSize;

    public PlateStack(int size) {
        currentStackSize = 0;
        stackSize = size;
        numStacks = 1;
        stacks = new ArrayList<>();
        stacks.add(0, new CustomStack<>());
    }

    public void push(int data) {
        if(numStacks == 0) {
            numStacks = 1;
            stacks.add(0, new CustomStack<>());
            stacks.get(0).push(data);
            currentStackSize++;
        } else if(currentStackSize == stackSize) {
            numStacks++;
            stacks.add(numStacks - 1, new CustomStack<>());
            stacks.get(numStacks - 1).push(data);
            currentStackSize = 1;
        } else {
            currentStackSize++;
            stacks.get(numStacks - 1).push(data);
        }
    }

    public int pop() throws NoSuchElementException {
        if(numStacks == 0) throw new NoSuchElementException();

        int data = stacks.get(numStacks - 1).pop();
        currentStackSize--;

        if(currentStackSize == 0) {
            stacks.remove(numStacks -1);
            numStacks--;
            if(numStacks != 0) {
                currentStackSize = stackSize;
            }
        }

        return data;
    }

    public int peek() throws NoSuchElementException {
        if (numStacks == 0) throw new NoSuchElementException();

        return stacks.get(numStacks - 1).peek();
    }

    public int getNumStacks() {
        return numStacks;
    }
}
