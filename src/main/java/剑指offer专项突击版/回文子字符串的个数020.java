package 剑指offer专项突击版;

/**
 * Title: 回文子字符串的个数020
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 回文子字符串的个数020 {
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 遍历回文中心点
            for (int j = 0; j < 2; j++) {
                // j=0,中心是一个点，j=1,中心是两个点
                int l = i;
                int r = i + j;
                while (l >= 0 && r < len && s.charAt(l--) == s.charAt(r++)) {
                    res++;
                }
                /*
                    中心拓展，遍历，只不过，中心可能是1个字符也可能是2个字符而已，
                    不可能出现3个字符作为中心的情况，
                    因为3个字符作为中心的话，他就是回文了，等于1个字符作为中心的情况
                 */
            }
        }
        return res;
    }
}
