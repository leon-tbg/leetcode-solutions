package stack.p0150_evaluate_reverse_polish_notation;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.function.IntBinaryOperator;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<String, IntBinaryOperator> ops = Map.of(
                "+", (a, b) -> a + b,
                "-", (a, b) -> a - b,
                "*", (a, b) -> a * b,
                "/", (a, b) -> a / b
        );

        for (String token : tokens) {
            if (ops.containsKey(token)) {
                int b = stack.pop();
                int a = stack.pop();

                stack.push(ops.get(token).applyAsInt(a, b));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
