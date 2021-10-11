package 程序员面试经典第六版;

/**
 * Title: 判定是否互为字符重排0102
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-11
 */
public class 判定是否互为字符重排0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] freq = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
