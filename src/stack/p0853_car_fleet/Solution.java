package stack.p0853_car_fleet;


import java.util.*;

class Solution {
    private record Entry(int position, int speed) {}

    public int carFleet(int target, int[] position, int[] speed) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            entries.add(new Entry(position[i], speed[i]));
        }
        entries.sort(Comparator.comparing(Entry::position).reversed());

        Deque<Double> stack = new ArrayDeque<>();
        for (Entry entry : entries) {
            double time = (double) (target - entry.position()) / entry.speed();

            if (stack.isEmpty() || stack.peek() < time) stack.push(time);
        }

        return stack.size();
    }
}
