package 剑指offer;

/**
 * Title: 数组中超过一半的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 数组中超过一半的数字 {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int res = nums[0];
        for (int i : nums) {
            if (votes == 0) {
                res = i;
            }
            votes = i == res ? votes + 1 : votes - 1;
        }
        return res;
    }
}
