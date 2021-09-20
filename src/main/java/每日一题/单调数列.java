package 每日一题;

/**
 * Title: 单调数列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-28
 */
public class 单调数列 {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len == 1) {
            return true;
        }
        int inx = 1;
        while (inx < len && A[inx] == A[inx - 1]) {
            inx++;
        }
        boolean large = A[0] < A[1];
        if (large) {
            for (int i = 2; i < len; i++) {
                if (A[i] < A[i - 1]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 2; i < len; i++) {
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
