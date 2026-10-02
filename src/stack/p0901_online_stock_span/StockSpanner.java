package stack.p0901_online_stock_span;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    private final Deque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[] {price, span});

        return span;
    }
}
