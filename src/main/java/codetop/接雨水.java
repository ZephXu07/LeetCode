package codetop;

/**
 * Title: 接雨水
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-06
 */
public class 接雨水 {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        /*
            左边遍历的下标
         */
        int right = height.length - 1;
        /*
            右边遍历的下标
         */
        int leftMax = height[left];
        /*
            左边最高
         */
        int rightMax = height[right];
        /*
            右边最高
         */
        int res = 0;
        while (left <= right) {
            /*
                当遍历到同一个结束
             */
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            /*
                更新左右边最大
             */
            if (leftMax <= rightMax) {
                /*
                    当左边小于等于右边时
                    限制接水的是左边，右边永远比左边大
                    即使当前遍历的左边下标其右侧比它小，
                    但总会因为存在柱子或者填满水而高起来
                    同样可以，但左边最高都是小于等于右边的
                    接不了更多的，所以限制接水的是左边的高度
                    最大高度 - 当前高度即是此处接水量
                 */
                res += leftMax - height[left];
                left ++;
            } else {
                /*
                    右边同理
                 */
                res += rightMax - height[right];
                right --;
            }
        }
        return res;
    }
}
