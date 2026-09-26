package stack.p0225_implement_stack_using_queues;

import java.util.Deque;
import java.util.ArrayDeque;

class MyStack {
    Deque<Integer> queue;

    public MyStack() {
        this.queue= new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.addLast(queue.pollFirst());
        }
    }

    public int pop() {
        return queue.pollFirst();
    }

    public int top() {
        return queue.peekFirst();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
