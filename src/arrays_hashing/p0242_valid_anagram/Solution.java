package arrays_hashing.p0242_valid_anagram;

// Runtime: O(n), Memory: O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if(arr[c - 'a'] <= 0) return false;

            arr[c - 'a']--;
        }

        return true;
    }
}
