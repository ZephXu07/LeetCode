package 每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title: 公平的糖果棒交换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-01
 */
public class 公平的糖果棒交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0;
        int bSum = 0;
        Set<Integer> memo = new HashSet<>();
        for (int k : A) {
            aSum += k;
            memo.add(k);
        }
        for (int k : B) {
            bSum += k;
        }
        int val = (aSum - bSum) / 2;
        int tmp;
        for (int i : B){
            tmp = val + i;
            if (memo.contains(tmp)) {
                return new int[]{tmp, i};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        公平的糖果棒交换 change = new 公平的糖果棒交换();
        int[] A = {1,2,5};
        int[] B = {2,4};
        System.out.println(Arrays.toString(change.fairCandySwap(A, B)));
    }
}
