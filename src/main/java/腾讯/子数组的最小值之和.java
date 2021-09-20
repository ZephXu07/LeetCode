package 腾讯;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 子数组的最小值之和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-12
 */
public class 子数组的最小值之和 {
    public int sumSubarrayMins(int[] arr) {
        int base = (int) 1e9 + 7;
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        //以arr[i]为最低，向两边寻找比其还低的边界，(r - l - 1) * 高则是此点的为最低的面积
        //若左边界没有则为-1，右边界没有则为len， len - (-1) - 1刚好就是长度，不需额外处理
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        //单调栈，寻找左边比arr[i]稍低一点的坐标，-1表时不存在
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        //单调栈，寻找右边比arr[i]稍低一点的坐标，arr长度表示不存在
        long res = 0;
        for (int i = 0; i < len; i++) {
            // i - left[i] 为坐标为i的数与左边大于他的数量（包括自身），right[i] - i右边同理
            res += (long) (i - left[i]) * (right[i] - i) * arr[i];
            //相乘是因为要求是连续的，所以从1-n个数共有n个，又因为左右，所以相乘
            res %= base;
        }
        return (int) res;
    }


    public static void main(String[] args) {
        子数组的最小值之和 res = new 子数组的最小值之和();
        int[] arr = {3,1,2,4};
//        int[] arr = {11,81,94,43,3};
        System.out.println(res.sumSubarrayMins(arr));
    }


}
