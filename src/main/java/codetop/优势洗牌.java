package codetop;

import java.util.*;

/**
 * Title: 优势洗牌
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-14
 */
public class 优势洗牌 {
    public int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        Arrays.sort(A);
        int[][] copy = new int[len][2];
        for (int i = 0; i < len; i++) {
            copy[i][0] = B[i];
            copy[i][1] = i;
            /*
                记录在原来 B 中的位置
             */
        }
        Arrays.sort(copy, Comparator.comparingInt(c -> c[0]));

        int left = 0;
        int right = len - 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            /*
                A、B都进行了排序
                如果A最小的比B最小的还小，此刻可田忌赛马，
                与 B 最大的进行比较，使 B 进行最大的浪费

                否则的话，用 A 最小与 B 最小的对比，节省自己的战力

             */
            if (A[i] <= copy[left][0]) {
                res[copy[right][1]] = A[i];
                right--;
            } else {
                res[copy[left][1]] = A[i];
                left++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        优势洗牌 res = new 优势洗牌();
        System.out.println(Arrays.toString(res.advantageCount(new int[]{2, 0, 4, 1, 2},
                new int[]{1, 3, 0, 0, 2})));
    }
}
