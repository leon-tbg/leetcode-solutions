package sliding_window.p0424_longest_repeating_character_replacement;

import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int longest = 0;

        while (right < s.length()) {
            map.merge(s.charAt(right), 1, Integer::sum);

            while (right - left - map.values().stream().max(Integer::compareTo).orElse(0) > k) {
                map.merge(s.charAt(left++), -1, Integer::sum);
            }

            longest = Math.max(longest, right - left);
            right++;
        }

        return longest;
    }
}
