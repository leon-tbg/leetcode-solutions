package arrays_hashing.p0912_sort_an_array;

class Solution {
    // Runtime: O(n * log n), Memory: O(n)
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = (end - start) / 2 + start;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] res = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                res[k] = nums[i++];
            }
            else {
                res[k] = nums[j++];
            }

            k++;
        }

        while (i <= mid) {
            res[k++] = nums[i++];
        }
        while (j <= end) {
            res[k++] = nums[j++];
        }

        i = 0;
        j = start;
        while(i < res.length) {
            nums[j++] = res[i++];
        }
    }
}
