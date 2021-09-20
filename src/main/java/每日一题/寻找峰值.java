package 每日一题;

/**
 * Title: 寻找峰值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            /*
                mid + 1 必定存在，即使 low + 1 = high 时 mid + 1 = high
                low == high 停止
             */
            if (nums[mid] < nums[mid + 1]) {
                /*
                    此时还在上坡
                 */
                low = mid + 1;
            } else {
                /*
                    mid != mid + 1
                    即此时 mid > mid + 1
                    此时在下坡，而mid - 1可能不存在或者 mid - 1 不是顶点而是上坡
                 */
                high = mid;
            }
        }
        return low;
    }
}
