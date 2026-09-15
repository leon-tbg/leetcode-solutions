package p0020_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

// Runtime: O(n), Memory: O(n)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;

                switch (stack.pop()) {
                    case '(':
                        if (c != ')') return false;
                        break;
                    case '[':
                        if (c != ']') return false;
                        break;
                    case '{':
                        if (c != '}') return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
