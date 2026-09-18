package arrays_hashing.p0303_range_sum_query_immutable;

class NumArray {
    // Runtime: O(n), Memory: O(n)
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        this.prefixSum = buildPrefixSum(nums);
    }

    private int[] buildPrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return prefixSum;
    }

    // Runtime: O(1), Memory: O(1)
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
