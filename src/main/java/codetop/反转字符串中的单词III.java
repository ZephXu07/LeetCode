package codetop;

import 每日一题.反转字符串二;

/**
 * Title: 反转字符串中的单词III
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-20
 */
public class 反转字符串中的单词III {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        int len = s.length();
        while (fast <= len) {
            if (fast == len || chars[fast] == ' ') {
                reverse(chars, slow, fast - 1);
                fast++;
                slow = fast;
            } else {
                fast++;
            }
        }
        return new String(chars);
    }

    private void reverse (char[] chars, int left, int right) {
        while (left < right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        反转字符串中的单词III res = new 反转字符串中的单词III();
        System.out.println(res.reverseWords("Let's take LeetCode contest"));
        System.out.println("s'teL ekat edoCteeL tsetnoc");
    }
}
