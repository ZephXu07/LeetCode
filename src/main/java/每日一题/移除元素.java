package 每日一题;

/**
 * Title: 移除元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-19
 */
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int inx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[inx] = nums[i];
                inx++;
            }
        }
        return inx;
    }
}
