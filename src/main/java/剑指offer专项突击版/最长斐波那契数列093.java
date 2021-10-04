package 剑指offer专项突击版;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 最长斐波那契数列093
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-03
 */
public class 最长斐波那契数列093 {
//    public int lenLongestFibSubseq(int[] arr) {
//        int len = arr.length;
//        Map<Integer, Integer> map = new HashMap<>(len);
//        for (int i = 0; i < len; i++) {
//            map.put(arr[i], i);
//        }
//
//        int[][] dp = new int[len][len];
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                int pre = arr[j] - arr[i];
//                if (map.containsKey(pre)) {
//                    int inx = map.get(pre);
//                    dp[i][j] = Math.max(2, dp[inx][i] + 1);
//                }
//                res = Math.max(res, dp[i][j]);
//            }
//        }
//        return res > 2 ? res : 0;
//    }

    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[len][len];
        /*
            最大元素 arr[i] ，次大元素 arr[j] 的斐波那契数列的最大长度
         */
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i][j] = 2;
                /*
                    如果找不到的，长度为 2
                    方便更新 res 做标记
                 */
                int pre = arr[i] - arr[j];
                /*
                    求出前一个数
                    如果比次大的元素的值还大，
                    说明 arr[j] 不是次大元素，跳过此枚举 j [0,i-1]

                 */
                if (pre >= arr[j]) {
                    break;
                }
                if (map.containsKey(pre)) {
                    /*
                        前一个数存在，求出下标
                        得出更大长度
                        当前 arr[inx] arr[j] arr[i]
                        或者 arr[inx] 也是某个数列的最大元素，再增加新的两个元素
                        长度取最大
                     */
                    int inx = map.get(pre);
                    dp[i][j] = Math.max(2, dp[j][inx]) + 1;
                }
                res = Math.max(res, dp[i][j]);
                /*
                    比较每个 arr[i] 最大，arr[j] 次大的数列的最长长度
                 */
            }
        }
        return res > 2 ? res : 0;
        /*
            如果找不到，res 只会为 2
            即 斐波那契数列长度为 0
         */
    }
}
