package codetop;

import java.util.*;

/**
 * Title: 最长重复子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-03
 */
public class 最长重复子串 {

    public String longestDupSubstring(String S) {
        int n = S.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = S.charAt(i) - 'a';
        }
        int a = 26;
        /*
            小写字母26个，所以系数使用26
         */
        long modulus = (long)Math.pow(2, 32);
        /*
            模数一般需要和被编码的信息数量的平方根的数量级相同，
            在本题中，相同长度的子串的数量不会超过 N 个，
            因此选取模数是 2^{32}（无符号整型数的最大值）是足够的。
            2 <= S.length <= 10^5
         */

        int left = 1, right = n;
        int L;
        boolean flag = false;
        while (left != right) {
            /*
                枚举长度，使用二分减少时间复杂度
             */
            L = left + (right - left) / 2;
            /*
                在整个字符串寻找长度为 L 的连续字符串
                看是否出现两次及以上
            */
            if (search(L, a, modulus, n, nums, S) != -1) {
                /*
                    在 [0,L-1] [1,L] ... [n - L, n-1]
                    中寻找是否有重复的长度为 L 的字符串
                    找到了则长度至少为 L 的重复字符串，返回的是起点
                    left 则增大，至少为 L+1
                 */
                left = L + 1;
                flag = true;
            } else {
                /*
                    找不到则缩减
                    right = L 是因为使用的是整数除法，当剩两个数时取的永远是左边的数
                    而左边的数每次是mid(L) + 1
                    停止条件是两个数相等
                 */
                right = L;
            }
        }
        if (!flag) {
            /*
                表示找到了
                当长度为 1 时不知道是否找到了
                或者是没找到，但right == left 停止了
                避免了在后面对整个字符串重新搜索是否有长度为 1 的字符串进行搜索的返回值是否不等于 -1 来确定
             */
            return "";
        }
        int start = search(left - 1, a, modulus, n, nums, S);
        /*
            search 函数返回的是长度为 left - 1的重复字符串的起点，
            题目要求的是整个此字符串，所以需要找出来
         */
        return S.substring(start, start + left - 1);
    }

    private int search(int L, int a, long modulus, int n, int[] nums, String S) {
        long h = 0;
        for (int i = 0; i < L; ++i){
            h = (h * a + nums[i]) % modulus;
            /*
                记录 [0,L-1]的哈希值
                计算 h0
             */
        }
        /*
            再慢慢查询 [1,L],[2,L+1] ... [n - L, n - 1]的哈希值
            查看是否相同
         */
        Map<Long, int[]> seen = new HashMap<>();
        /*
            记录哈希值与起始、结束下标
            在哈希值相同时看是否伪哈希还是字符串一样
         */
        seen.put(h, new int[]{0, L - 1});
        long aL = 1;
        for (int i = 1; i <= L; ++i) {
            aL = (aL * a) % modulus;
            /*
                计算 a^L
             */
        }

        for (int start = 1; start < n - L + 1; ++start) {
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;

            if (seen.containsKey(h)) {
                /*
                    哈希值相同再检测是否字符串相同
                 */
                if (isEqual(S, seen.get(h), new int[]{start, start + L - 1})) {
                    return start;
                    /*
                        相同字符串则返回起点
                     */
                }
            }
            seen.put(h, new int[]{start, start + L - 1});
            /*
                记录字符串哈希值与字符串的起点终点
             */
        }
        return -1;
        /*
            找不到 - 1
         */
    }

    private boolean isEqual (String s, int[] a, int[] b) {
        /*
            判断字符串是否相同
         */
        for (int i = a[0], j = b[0]; i <= a[1] && j <= b[1]; i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
