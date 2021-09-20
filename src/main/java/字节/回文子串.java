package 字节;

/**
 * Title: 回文子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-31
 */
public class 回文子串 {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
    /*

        0	0	0
        1	0	1
        2	1	1
        3	1	2
        4	2	2
        5	2	3
        6	3	3

        长度为 n 的字符串会生成 2n−1 组回文中心，l = i / 2, r = i / 2 + i % 2;
            当（0，0）时可以，（1，1）中心时可以，再向两边扩展，其他同理
     */
}
