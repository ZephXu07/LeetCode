package labuladong;

/**
 * Title: labuladong.MinInsertions
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-23
 */
public class MinInsertions {
    public int minInsertions(String s) {
        int left = 0;
        int right = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                right += 2;
                if (right % 2 != 0) {
                    left ++;
                    right --;
                }
            } else {
                right --;
                if (-1 == right) {
                    left ++;
                    right = 1;
                }
            }
        }
        return left + right;
    }

    public static void main(String[] args) {
        String s = "(()))(()))()())))";
        MinInsertions insertions = new MinInsertions();
        int min = insertions.minInsertions(s);
        System.out.println(min);
    }
}
