package stack.p0895_maximum_frequency_stack;

import java.util.*;

class FreqStack {
    private final Map<Integer, Integer> freq;
    private final Map<Integer, Deque<Integer>> group;
    private int maxFreq = 0;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int val) {
        int f = freq.merge(val, 1, Integer::sum);
        maxFreq = Math.max(maxFreq, f);
        group.computeIfAbsent(f, k -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        Deque<Integer> top = group.get(maxFreq);
        int x = top.pop();
        freq.merge(x, -1, Integer::sum);

        if (top.isEmpty()) {
            group.remove(maxFreq);
            maxFreq--;
        }

        return x;
    }
}
