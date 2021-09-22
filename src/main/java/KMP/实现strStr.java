package KMP;

import java.util.Arrays;

/**
 * Title: 实现strStr
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-03
 */
public class 实现strStr {


    public int strStr (String haystack, String needle) {
        if (needle.length() == 0) {
            /*
                模式串为空，可以匹配任何的文本串
             */
            return 0;
        }

        int[] next = getNext(needle);
        /*
            得到next数组（前缀表）
         */
        int j = -1;
        /*
            next数组里记录的起始位置为-1
         */
        for (int i = 0; i < haystack.length(); i++) {
            /*
                haystack[i] 与 needle[j + 1] 比较
                （因为j == -1 开始）
             */
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                /*
                     haystack[i] 与 needle[j + 1] 不相同，j
                     就要从next数组里寻找下一个匹配 haystack[i] 的位置
                     不断回溯
                     直到找到相同的前缀的位置 或者 j == -1
                      needle 串从 0 下标再开始
                 */
                j = next[j];
            }

            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                /*
                    相同的前缀末尾，j++
                     i的增加在for循环里
                 */
                j++;
            }

            if (j == needle.length() - 1) {
                /*
                    j指向了模式串 needle 的末尾
                    说明模式串 needle 完全匹配文本串 haystack 里的某个子串了
                    文本串 haystack 里出现了模式串 needle
                 */
                return i - needle.length() + 1;
                /*
                    模式串从 0 开始的
                    所以减去模式串长度再加一才是文本串起始的位置
                 */
            }

        }

        return -1;
        /*
            完全没匹配到，返回 - 1
         */
    }

    private int[] getNext (String s) {
        int j = -1;
        /*
            在next数组中记录的起始位置是-1
            下面的操作都是 j + 1 使不会溢出范围
         */
        int[] next = new int[s.length()];
        next[0] = j;
        /*
            next[i] 表示 i（包括i）之前最长相等的前后缀长度（其实就是j）
            所以初始化next[0] = j
         */
        for (int i = 1; i < s.length(); i++) {
            /*
                next[0] 已经确定为 - 1
                从下标 1 开始
             */
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                /*
                    前后缀不相同了，向前回溯
                    此处是 s[j + 1] 所以从 j 开始即可

                    当 s[i] == s[j+1] 了，即前后缀末尾相同了即可继续新的前后缀计算最长长度
                    或者全部回溯完， j == -1，没有找到相同的前缀后缀，结束
                 */
                j = next[j];
                /*
                    回溯到包括前一个字符的字符串的最长相等前后缀长度
                 */
            }

            if (s.charAt(i) == s.charAt(j + 1)) {
                /*
                    当 s[i] == s[j+1] 了，
                    找到相同的前后缀
                    继续新的前后缀计算最长长度
                 */
                j++;
            }

            next[i] = j;
            /*
                记录 i（包括i）之前最长相等的前后缀长度（其实就是j）
             */
        }

        return next;
    }


    public static void main(String[] args) {
        实现strStr res = new 实现strStr();
        System.out.println(Arrays.toString(res.getNext("aacecaaa#aaacecaa")));
    }
}
