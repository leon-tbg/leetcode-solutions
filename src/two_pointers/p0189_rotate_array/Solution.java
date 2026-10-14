package two_pointers.p0189_rotate_array;

class Solution {
    public void rotate(int[] nums, int k) {
        reverseArray(nums, 0, nums.length - 1);

        k = k % nums.length;
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray (int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }
}
