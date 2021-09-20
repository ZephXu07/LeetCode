package 字节;

/**
 * Title: 盛水最多的容器
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-29
 */
public class 盛水最多的容器 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            int tmp = Math.min(height[right], height[left]) * (right - left);
            res = Math.max(res, tmp);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
