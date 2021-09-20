package 剑指offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Title: 扑克牌中的顺子
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-07
 */
public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < 5; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (nums[i - 1] != 0 && nums[i] != nums[i - 1] + 1) {
                int tmp = nums[i] - nums[i - 1] - 1;
                if (tmp <= zeroCount) {
                    zeroCount -= tmp;
                } else {
                    return false;
                }
            }
            if (nums[i - 1] == nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        扑克牌中的顺子 res = new 扑克牌中的顺子();
        int[] nums = {0,0,2,2,5};
        System.out.println(res.isStraight(nums));
    }
}
