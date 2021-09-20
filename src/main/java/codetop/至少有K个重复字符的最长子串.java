package codetop;

/**
 * Title: 至少有K个重复字符的最长子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 至少有K个重复字符的最长子串 {
//    public int longestSubstring(String s, int k) {
//        if (s.length() < k) {
//            /*
//                由题目知 k min = 1
//                字符串长度都小于 k 了，
//                不可能字符串的里面的每个字符出现次数至少为 k，
//                直接返回 0
//             */
//            return 0;
//
//        }
//        int[] count = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i) - 'a']++;
//            /*
//                计算字符串中每个字符出现的次数
//             */
//        }
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            /*
//                对存在于字符串的字符的次数进行判断
//                如果字符 c 出现的次数小于 k
//                表示含有 c 的字符串不符合题目要求的
//                至少每个字符的重复次数为 k
//                所以直接使用 c 字符来切割字符串
//                切割出来的都不含 c 字符了
//                再对每个切割出来的字符串调用此函数
//                符合条件则返回，否则继续切割
//                直到字符串里的每个元素出现的次数都至少为 k
//
//
//             */
//            if (count[c - 'a'] < k) {
//                int res = 0;
//                //将字符串切分成多个小段 分别在求解
//                for (String str : s.split(String.valueOf(c))) {
//                    res = Math.max(res, longestSubstring(str, k));
//                    /*
//                        记录其中长度最大的
//                     */
//                }
//                return res;
//                /*
//                    返回，此时的 res 是否不为 0 是未知的
//                 */
//            }
//        }
//
//        return s.length();
//        /*
//            能到达此时，表示这个字符串都没有被切割过
//            即其元素出现的次数都至少为 k
//            否则切分了，一定在循环里返回 res 了
//
//         */
//    }


    public int longestSubstring(String s, int k) {
        int res = 0;
        int len = s.length();
        for (int i = 1; i <= 26; i++) {
            /*
                枚举字符串中字符的种类
             */
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
