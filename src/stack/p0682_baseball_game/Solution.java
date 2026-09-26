package stack.p0682_baseball_game;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int score = 0;

        for (String operation : operations) {
            if (operation.equals("+")) {
                int tmp = stack.pop();
                int sum = stack.peek() + tmp;
                stack.push(tmp);
                stack.push(sum);
            }
            else if (operation.equals("D")) {
                stack.push(stack.peek() * 2);
            }
            else if (operation.equals("C")) {
                stack.pop();
            }
            else {
                stack.push(Integer.valueOf(operation));
            }
        }

        int n = stack.size();
        for (int i = 0; i < n; i++) {
            score += stack.pop();
        }

        return score;
    }
}
