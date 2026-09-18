package arrays_hashing.p0169_majority_element;

class Solution {
    // Runtime: O(n), Memory: O(1)
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += candidate == num ? 1 : -1;
        }

        return candidate;
    }
}
