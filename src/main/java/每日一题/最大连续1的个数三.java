package 每日一题;

/**
 * Title: 最大连续1的个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-15
 */
public class 最大连续1的个数三 {
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
                if (A[left] == 0) {
                    count--;
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = 3;
        最大连续1的个数三 res = new 最大连续1的个数三();
        System.out.println(res.longestOnes(A, K));
    }
}
