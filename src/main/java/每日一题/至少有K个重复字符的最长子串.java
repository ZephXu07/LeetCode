package 每日一题;

/**
 * Title: 至少有K个重复字符的最长子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-27
 */
public class 至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        if(s.length() < k) {
            return 0;
        }
        int [] count = new int [26];
        for(int i = 0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //判断条件 找到小于出现k次的字符串
            if(count[c - 'a'] < k)
            {
                int res = 0;
                //将字符串切分成多个小段 分别在求解
                for (String str : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(str, k));
                    //第一次按照第一个频次小于k的字符进行切割成子集，
                    // 剩下那些频次小于k的字符还在这些子集中。
                    // 递归的部分，又对这些子集进行切割，会逐步把这些频次小于k的挑出来
                }
                return res;
            }
        }
        //原字符串里面没有小于k的字符串 直接返回字符串长度
        return s.length();
    }

    public int longestSubstring(int k, String s) {
        int res = 0;
        int len = s.length();
        for (int i = 1; i <= 26; i++) {
            int left = 0;
            int right =0;
            int[] freq = new int[26];
            int total = 0;
            int less = 0;
            while (right < len) {
                int c = s.charAt(right) - 'a';
                freq[c]++;
                if (freq[c] == 1) {
                    total++;
                    less++;
                    //种类 + 1
                    // 即不符合要求的 + 1
                }
                if (freq[c] == k) {
                    less--;
                    //符合要求 + 1，即不符合要求 - 1
                }

                while (total > i) {
                    //枚举种类，种类大于约定时缩小左边界
                    c = s.charAt(left) - 'a';
                    freq[c]--;
                    if (freq[c] == k - 1) {
                        //符合要求 - 1，即不符合要求 + 1
                        less++;
                    }
                    if (freq[c] == 0) {
                        ////种类 - 1，即不符合要求的 - 1
                        less--;
                        total--;
                    }
                    left++;
                 }

                right++;

                if (less == 0) {
                    //当不符合要求为0，即枚举的多少种类字母中频率达要求
                    res = Math.max(res, right - left);
                }

            }
        }

        return res;
    }
}
