package arrays_hashing.p0560_subarray_sum_equals_k;

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int res = 0;

        for (int num : nums) {
            prefixSum += num;
            int sum = prefixSum - k;

            if (sum == 0) {
                res++;
            }
            if (map.containsKey(sum)) {
                res += map.get(sum);
            }

            if (map.containsKey(prefixSum)) {
                map.merge(prefixSum, 1, Integer::sum);
            } else {
                map.put(prefixSum, 1);
            }
        }

        return res;
    }
}
