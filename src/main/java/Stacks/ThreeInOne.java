package Stacks;

import java.util.NoSuchElementException;

public class ThreeInOne {
    private final int size;
    private final int[] stackArray;
    private final int[] stackSizes;

    public ThreeInOne(int sizePerStack) {
        size = sizePerStack;
        int numStacks = 3;
        stackArray = new int[numStacks * size];
        stackSizes = new int[size];
        for(int i = 0; i < numStacks; i++) {
            stackSizes[i] = 0;
        }
    }

    public int pop(int stackNum) throws NoSuchElementException {
        if(stackSizes[stackNum] == 0) throw new NoSuchElementException();
        int data = stackArray[getTopIndex(stackNum)];
        stackSizes[stackNum] = stackSizes[stackNum] - 1;
        return data;
    }

    public void push(int stackNum, int stackValue) throws StackOverflowError {
        if(stackSizes[stackNum] == size) {
            throw new StackOverflowError();
        }

        int topIndex = getTopIndex(stackNum);
        int newIndex = topIndex + 1;
        stackArray[newIndex] = stackValue;
        stackSizes[stackNum] = stackSizes[stackNum] + 1;
    }

    public int peek(int stackNum) throws NoSuchElementException {
        if(stackSizes[stackNum] == 0) {
            throw new NoSuchElementException();
        }
        return stackArray[getTopIndex(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return stackSizes[stackNum] == 0;
    }

    private int getTopIndex(int stackNum) {
        int offset = stackNum * size;
        int numItems = stackSizes[stackNum];

        return offset + numItems;
    }

}
