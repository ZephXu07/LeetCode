package labuladong;

/**
 * Title: labuladong.FindErrorNums
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-18
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int rep = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                rep = Math.abs(nums[index]);
            } else {
                nums[index] *= -1;
            }
        }
        int miss = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                miss = i + 1;
            }
        }
        return new int[]{rep, miss};
    }

}
