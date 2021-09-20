package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 找到所有数组中消失的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-13
 */
public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int cur = nums[i] - 1;
            while (cur >= 0) {
                int tmp = cur;
                cur = nums[cur] - 1;
                nums[tmp] = -1;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != -1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        找到所有数组中消失的数字 res = new 找到所有数组中消失的数字();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = res.findDisappearedNumbers(nums);
        for (int i : list){
            System.out.print(i + "\t");
        }
    }
}
