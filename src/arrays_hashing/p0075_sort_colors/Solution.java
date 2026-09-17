package arrays_hashing.p0075_sort_colors;

// Runtime: O(n), Memory: O(1)
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                nums[mid++] = nums[left];
                nums[left++] = 0;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                nums[mid] = nums[right];
                nums[right--] = 2;
            }
        }
    }
}
