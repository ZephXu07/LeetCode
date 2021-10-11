package 程序员面试经典第六版;

/**
 * Title: 判定字符是否唯一0101
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-11
 */
public class 判定字符是否唯一0101 {
    public boolean isUnique(String astr) {
        long low = 0;
        long high = 0;

        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (c >= 64) {
                int bit = (int) ((high >> (c - 64)) & 1);
                if (bit == 1) {
                    return false;
                }
                high |= 1L << (c - 64);
            } else {
                int bit = (int) ((low >> c ) & 1);
                if (bit == 1) {
                    return false;
                }
                low |= 1L << c;
            }
        }
        return true;
    }
}
