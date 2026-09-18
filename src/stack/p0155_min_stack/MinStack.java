package stack.p0155_min_stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    // Runtime: O(1), Memory: O(1) | for all methods
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int value) {
        stack.push(value);

        if (value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        int value = stack.pop();

        if (value == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
