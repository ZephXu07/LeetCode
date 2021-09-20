package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 数组形式的整数加法
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-22
 */
public class 数组形式的整数加法 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int cur = A.length - 1;
        List<Integer> res = new LinkedList<>();
        int value = 0;
        int sign = 0;
        int tmp = 0;
        while (cur >= 0 && 0 != K) {
            value = K % 10;
            tmp = value + A[cur] + sign;
            if (tmp >= 10) {
                tmp %= 10;
                sign = 1;
            } else {
                sign = 0;
            }
            res.add(tmp);
            cur--;
            K /= 10;
        }
        if (cur >= 0) {
            while (cur >= 0) {
                tmp = A[cur] + sign;
                if (tmp >= 10) {
                    tmp %= 10;
                    sign = 1;
                } else {
                    sign = 0;
                }
                res.add(tmp);
                cur--;
            }
        }
        if (0 != K) {
            while (0 != K) {
                value = K % 10;
                tmp = value + sign;
                if (tmp >= 10) {
                    tmp %= 10;
                    sign = 1;
                } else {
                    sign = 0;
                }
                res.add(tmp);
                K /= 10;
            }
        }
        if (sign == 1) {
            res.add(1);
        }
        int len = res.size();
        for (int i = 0; i < len / 2; i++) {
            tmp = res.get(i);
            res.set(i, res.get(len - i - 1));
            res.set(len - i - 1, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        数组形式的整数加法 res = new 数组形式的整数加法();
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        int K = 1;
        System.out.println(Arrays.toString(res.addToArrayForm(A, K).toArray()));

//        List<Integer> res = new LinkedList<>();
//        res.add(4);
//        res.add(3);
//        res.add(2);
//        res.add(1);
//        int len = res.size();
//        int tmp;
//        for (int i = 0; i < len / 2; i++) {
//            tmp = res.get(i);
//            res.set(i, res.get(len - i - 1));
//            res.set(len - i - 1, tmp);
//        }

    }
}
