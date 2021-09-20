package codetop;

/**
 * Title: 最大连续1的个数III
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 最大连续1的个数III {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                count++;
            }
            while (count > K) {
                if (A[left++] == 0) {
                    count--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
