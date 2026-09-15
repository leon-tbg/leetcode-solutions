package p0088_merge_sorted_array;

class Solution {
    // Runtime: O(m + n), Memory: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            }
            else {
                nums1[i] = nums2[n - 1];
                n--;
            }

            i--;
        }

        for (int j = m; j > 0; j--) {
            nums1[i] = nums1[m - 1];
            m--;
            i--;
        }
        for (int j = n; j > 0; j--) {
            nums1[i] = nums2[n - 1];
            n--;
            i--;
        }
    }
}

