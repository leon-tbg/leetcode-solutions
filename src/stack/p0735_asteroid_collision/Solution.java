package stack.p0735_asteroid_collision;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                    continue;
                }

                int collider = stack.pop();

                if (Math.abs(asteroids[i]) == collider || collider < 0) continue;

                if (Math.max(Math.abs(asteroids[i]), collider) == collider) {
                    stack.push(collider);
                }
                else {
                    i--;
                }
            }
            else {
                stack.push(asteroids[i]);
            }
        }

        int n = stack.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[n - i - 1] = stack.pop();
        }
        return res;
    }
}
