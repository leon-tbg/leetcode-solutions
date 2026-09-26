package arrays_hashing.p0238_product_of_array_except_self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length + 1];
        prefixProduct[0] = 1;
        int[] suffixProduct = new int[nums.length + 1];
        suffixProduct[nums.length] = 1;

        for (int i = 0; i < nums.length; i++) {
            prefixProduct[i + 1] = prefixProduct[i] * nums[i];
        }

        for (int i = nums.length; i > 0; i--) {
            suffixProduct[i - 1] = suffixProduct[i] * nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixProduct[i] * suffixProduct[i + 1];
        }

        return nums;
    }
}
