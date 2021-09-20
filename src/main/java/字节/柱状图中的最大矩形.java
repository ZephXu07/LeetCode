package 字节;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 柱状图中的最大矩形
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-31
 */
public class 柱状图中的最大矩形 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        //以height[i]为最低，向两边寻找比其还低的边界，(r - l - 1) * 高则是此点的为最低的面积
        //若左边界没有则为-1，右边界没有则为len， len - (-1) - 1刚好就是长度，不需额外处理
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        //单调栈，寻找左边比height[i]稍低一点的坐标
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        //单调栈，寻找右边比height[i]稍低一点的坐标
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        //取最大值
        return res;
    }

    public static void main(String[] args) {
        柱状图中的最大矩形 res = new 柱状图中的最大矩形();
//        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {2,4};
//        int[] heights = {0,9};
//        int[] heights = {2,0,2};
        int[] heights = {2,1,2};
        System.out.println(res.largestRectangleArea(heights));
    }
}
