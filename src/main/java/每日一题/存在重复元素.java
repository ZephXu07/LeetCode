package 每日一题;

import java.util.Arrays;

/**
 * Title: 存在重复元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-13
 */
public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
