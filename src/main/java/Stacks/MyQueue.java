package Stacks;


import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> correct;
    private final Stack<Integer> reverse;


    public MyQueue() {
        correct = new Stack<>();
        reverse = new Stack<>();
    }

    public void push(int data) {
        if(correct.isEmpty() && reverse.isEmpty()) {
            correct.push(data);
        } else if(correct.isEmpty()) {
            swapStack();
            correct.push(data);
        } else {
            correct.push(data);
        }
    }

    public int peek() throws EmptyStackException {
        if(correct.isEmpty() && !reverse.empty()) {
            return reverse.peek();
        } else if(!correct.isEmpty()) {
            swapStack();
            return reverse.peek();
        } else {
            throw new EmptyStackException();
        }
    }

    public int pop() throws EmptyStackException{
        if(correct.isEmpty() && !reverse.isEmpty()) {
            return reverse.pop();
        } else if(!correct.isEmpty()) {
            swapStack();
            return reverse.pop();
        } else {
            throw new EmptyStackException();
        }
    }

    private void swapStack() {
        if(correct.isEmpty()) {
            while(!reverse.isEmpty()) {
                correct.push(reverse.pop());
            }
        } else {
            while(!correct.isEmpty()) {
                reverse.push(correct.pop());
            }
        }

    }

}
