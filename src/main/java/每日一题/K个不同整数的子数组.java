package 每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: K个不同整数的子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-09
 */
public class K个不同整数的子数组 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return helper(A, K) - helper(A, K - 1);
    }

    private int helper(int[] A, int K) {
        int len = A.length;
        int left = 0;
        int right = 0;
        int[] memo = new int[len + 1];
        int count = 0;
        int res = 0;
        while (right < len) {
            if (memo[A[right]] == 0) {
                count++;
            }
            memo[A[right]]++;
            right++;
            while (count > K) {
                memo[A[left]]--;
                if (memo[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        K个不同整数的子数组 k = new K个不同整数的子数组();
        int[] A = {1,2,1,2,3};
        int K = 2;
        System.out.println(k.subarraysWithKDistinct(A, K));
    }
}
