package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 数组中重复的数据
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-07
 */
public class 数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        /*
            重复的数变成坐标的话指向同一个位置，如果那个位置的数是负数，则说明已经有了，
            因为每遍历一次就把其取反
         */
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int inx = Math.abs(nums[i]) - 1;
            if (nums[inx] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[inx] *= -1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        数组中重复的数据 res = new 数组中重复的数据();
        res.findDuplicates(new int[] {4,3,2,7,8,2,3,1});
    }
}
