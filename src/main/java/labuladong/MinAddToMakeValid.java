package labuladong;

/**
 * Title: labuladong.MinAddToMakeValid
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-23
 */
public class MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
//        Stack<Character> stack = new Stack<>();
        int left = 0;
        int count = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
//                stack.push('(');
                left ++;
            } else if (c == ')') {
//                if (!stack.empty()) {
//                    stack.pop();
                if (left != 0) {
                    left --;
                } else {
                    count ++;
                }
            }
        }
        return count + left;
    }

    public static void main(String[] args) {
        String s = "()))((";
        int res = new MinAddToMakeValid().minAddToMakeValid(s);
        System.out.println(res);
    }
}
