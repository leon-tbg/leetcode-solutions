package arrays_hashing.p0128_longest_consecutive_sequence;

import java.util.HashMap;

class Solution {
    /**
     * Keeps track of which elements belong to the same set.
     * The elements are the indices 0 to n-1.
     */
    private static class UnionFind {
        final int[] parent;
        final int[] size;

        /**
         * Creates a structure in which each of the n elements is in its own set.
         *
         * @param n number of elements
         */
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * Returns the representative of the set containing the given element.
         *
         * @param idx index of the element
         * @return index of the representative
         */
        int find(int idx) {
            while (parent[idx] != idx) {
                parent[idx] = parent[parent[idx]];
                idx = parent[idx];
            }
            return idx;
        }

        /**
         * Unifies the sets of element a and b.
         * <p>
         * The representative of the smaller set is attached to the larger set.
         * If both sets have the same size, the set containing {@code b} is attached to the set containing {@code a}.
         * Does nothing if both elements are already in the same set.
         *
         * @param a index of the first element
         * @param b index of the second element
         */
        void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);

            if (ra == rb) {
                return;
            }

            if (size[ra] < size[rb]) {
                parent[ra] = rb;
                size[rb] += size[ra];
            }
            else {
                parent[rb] = ra;
                size[ra] += size[rb];
            }
        }

    }

    // Runtime: O(n) Memory: O(n)
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> index = new HashMap<>();

        for (int num : nums) {
            index.putIfAbsent(num, index.size());
        }

        UnionFind unionFind = new UnionFind(index.size());

        for (int num : index.keySet()) {
            Integer next = index.get(num + 1);
            if (next != null) {
                unionFind.union(index.get(num), next);
            }
        }

        int highest = 0;
        for (int i = 0; i < index.size(); i++) {
            if (unionFind.parent[i] != i) continue;

            highest = Math.max(highest, unionFind.size[i]);
        }

        return highest;
    }
}
