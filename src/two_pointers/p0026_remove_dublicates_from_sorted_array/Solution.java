package two_pointers.p0026_remove_dublicates_from_sorted_array;

class Solution {
    // Runtime: O(n), Memory: O(1)
    public int removeDuplicates(int[] nums) {
        int read = 1;
        int write = 1;

        while (read < nums.length) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
            read++;
        }

        return write;
    }
}
