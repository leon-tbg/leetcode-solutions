package arrays_hashing.p0229_majority_element_ii;

import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.size() > 2) {
                map.replaceAll((key, value) -> value - 1);
                map.entrySet().removeIf(entry -> entry.getValue() < 1);
            }

            if (map.containsKey(num)) {
                map.merge(num, 1, Integer::sum);
            }
            else {
                map.put(num, 1);
            }
        }

        return map.keySet().stream()
                .filter(key -> {
                    int count = 0;

                    for (int num : nums) {
                        if (num == key) count++;
                    }

                    return count > nums.length / 3;
                })
                .toList();
    }
}
