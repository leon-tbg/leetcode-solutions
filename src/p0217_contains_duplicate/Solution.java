package p0217_contains_duplicate;

import java.util.HashSet;

public class Solution {
    // Time: O(n), Space: O(n)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
