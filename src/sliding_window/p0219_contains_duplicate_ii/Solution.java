package sliding_window.p0219_contains_duplicate_ii;

import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i - left > k) window.remove(nums[left++]);

            if (window.contains(nums[i])) return true;
            window.add(nums[i]);
        }

        return false;
    }
}
