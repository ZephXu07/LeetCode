package 字节;

/**
 * Title: 最长重复数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 最长重复数组 {
    public int findLength(int[] A, int[] B) {
//        int len = A.length;
//        int[][] dp = new int[len + 1][len + 1];
//        int res = 0;
//        for (int i = len - 1; i >= 0; i--) {
//            for (int j = len - 1; j >= 0; j--) {
//                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
//                res = Math.max(res, dp[i][j]);
//            }
//        }
//        return res;
        int len = A.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res,
                    maxLen(A, B, 0, len - i - 1, i + 1));
        }

        for (int i = 1; i < len; i++) {
            res = Math.max(res,
                    maxLen(A, B, i, 0, len - i));
        }
        return res;


    }

    private int maxLen(int[] A, int[] B, int aInx, int bInx, int len) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (A[i + aInx] == B[i + bInx]) {
                count++;
            } else {
                count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        最长重复数组 res = new 最长重复数组();
        System.out.println(res.findLength(A, B));
    }
}
