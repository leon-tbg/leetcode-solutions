package arrays_hashing.p0229_majority_element_ii;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution0 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.merge(num, 1, Integer::sum);
            }
            else {
                map.put(num, 1);
            }
        }

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > nums.length / 3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
