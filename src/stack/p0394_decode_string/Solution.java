package stack.p0394_decode_string;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        Deque<Character> charStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ']') charStack.push(c);
            else {
                while (!charStack.isEmpty() && charStack.peek() != '[') {
                    sb.append(charStack.pop());
                }
                String inner = sb.reverse().toString();
                sb.setLength(0);
                charStack.pop();

                while (!charStack.isEmpty() && Character.isDigit(charStack.peek())) {
                    sb.append(charStack.pop());
                }
                int multiplier = Integer.parseInt(sb.reverse().toString());
                sb.setLength(0);

                inner = sb.repeat(inner, multiplier).toString();
                sb.setLength(0);

                for (char innerChar : inner.toCharArray()) {
                    charStack.push(innerChar);
                }
            }
        }

        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }

        return sb.reverse().toString();
    }
}
