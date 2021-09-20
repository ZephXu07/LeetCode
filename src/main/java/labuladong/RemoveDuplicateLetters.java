package labuladong;

import java.util.*;

/**
 * Title: labuladong.RemoveDuplicateLetters
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-17
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        char tmp;
        for (int i = 0; i < s.length(); i++) {
            tmp = s.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            tmp = s.charAt(i);
            map.put(tmp, map.get(tmp) - 1);
            if (set.contains(tmp)) {
                continue;
            }
            while (!stack.empty() && tmp < stack.peek()) {
                if (map.get(stack.peek()) == 0) {
                    break;
                }
                set.remove(stack.pop());
            }
            stack.push(tmp);
            set.add(tmp);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
