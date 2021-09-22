package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 加一66
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-22
 */
public class 加一66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                /*
                    没进位直接结束
                 */
                return digits;
            }
        }
        /*
            到此时是有多个 9 使得长度加一
            因此除第一位外都是 0
         */
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
