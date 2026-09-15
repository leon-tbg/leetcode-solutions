package arrays_hashing.p0014_longest_common_prefix;

class Solution {
    // Runtime: O(n * m), Memory: O(m) | m = length of longest string
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (String s : strs) {
            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
