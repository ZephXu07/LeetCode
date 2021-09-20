package labuladong;

/**
 * Title: labuladong.Trap
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-17
 */
public class Trap {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                res += leftMax - height[left];
                left ++;
            } else {
                res += rightMax - height[right];
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        Trap trap = new Trap();
        int i = trap.trap(height);
        System.out.println(i);
    }

}
