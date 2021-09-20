package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 划分字母区间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-26
 */
public class 划分字母区间 {
    public List<Integer> partitionLabels(String s) {
         /*
            记录字符串中字符的最大下标
            使用贪心的思想
            进行遍历，开始 start = 0每个字符对应的最大下标为右边界 end
            直到右边界没在扩大，此时必有 i == end
            则表示 [start, end] 里面的字符最大下标是 end，
            即此范围的字母没有在其他地方出现，否则 end 会更大
            然后 start = end + 1，end 继续扩大与 i 比较
            0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23
            a  b  a  b  c  b  a  c  a  d  e  f  e  g  d  e  h  i  j  h  k  l  i  j
            8  5  8  5  7  5  8  7  8 14 15  11 15 13 14 15 19 22 23 19 20 21 22 23

            遍历到下标 8 时即一个
            遍历到下标 15 时即一个
            遍历到下标 23 时即一个
         */
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, index[s.charAt(i) - 'a']);

            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        划分字母区间 res = new 划分字母区间();
        System.out.println(res.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
