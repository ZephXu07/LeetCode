package 每日一题;

/**
 * Title: 非递减数列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-07
 */
public class 非递减数列 {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if (x > y) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        非递减数列 res = new 非递减数列();
        int[] nums = {3,4,2,3};
        System.out.println(res.checkPossibility(nums));
    }
}
