package 剑指offer专项突击版;

import 每日一题.用Rand7实现Rand10;

/**
 * Title: 单词长度的最大乘积003
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 单词长度的最大乘积003 {
    public int maxProduct(String[] words) {
        /*
            二进制标记，
            相与为零表示没有重复字符
            一一比较寻找最长
         */
        int len = words.length;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                int inx = w.charAt(j) - 'a';
                count[i] |= 1 << inx;
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if ((count[i] & count[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
