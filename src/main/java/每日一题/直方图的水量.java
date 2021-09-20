package 每日一题;

/**
 * Title: 直方图的水量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-02
 */
public class 直方图的水量 {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
            //长度为0或1直接返回0
        }
        int left = 0;
        int len = height.length;
        int right = len - 1;
        while (left < len && height[left] == 0) {
            //前置0剔除
            left++;
        }
        while (right >= 0 &&height[right] == 0) {
            //后置0剔除
            right--;
        }
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            //左边已遍历的最高
            rightMax = Math.max(rightMax, height[right]);
            //右边已遍历的最高
            if (height[left] >= height[right]) {
                res += rightMax - height[right];
                right--;
            } else {
                res += leftMax - height[left];
                left++;
            }
            //不需要知道左右边最高，需要知道的是哪边低，低的决定水量
            //即使左边或者右边小于知道的最大值，但当遍历到左边或右边时小于最大值的会被填满水
        }
        return res;
    }

    public static void main(String[] args) {
        直方图的水量 res = new 直方图的水量();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(res.trap(height));
    }
}
