package codetop;

import javax.print.DocFlavor;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 求区间最小数乘区间和的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 求区间最小数乘区间和的最大值 {
    public int getMax (int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        //以height[i]为最低，向两边寻找比其还低的边界，(r - l - 1) * 高则是此点的为最低的面积
        //若左边界没有则为-1，右边界没有则为len， len - (-1) - 1刚好就是长度，不需额外处理
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        //单调栈，寻找左边比height[i]稍低一点的坐标
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        int[] pre = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, nums[i] * (pre[right[i]] - pre[left[i] + 1]));
        }
        //取最大值
        return res;
    }

    public static void main(String[] args) {
        求区间最小数乘区间和的最大值 res = new 求区间最小数乘区间和的最大值();
        System.out.println(res.getMax(new int[]{6, 2, 1}));
    }
}
