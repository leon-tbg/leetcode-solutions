package two_pointers.p0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left]+ nums[right];

                if (threeSum > 0) {
                    right--;
                }
                else if (threeSum < 0) {
                    left++;
                }
                else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    res.add(triplet);

                    do left++;
                    while (nums[left] == nums[left - 1] && left < right);
                }
            }
        }

        return res;
    }
}
