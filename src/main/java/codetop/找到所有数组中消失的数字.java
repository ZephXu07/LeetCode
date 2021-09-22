package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 找到所有数组中消失的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-22
 */
public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            /*
                下标是 [0,l-1]
                值是 [1,l]
                因此遍历到的值减一则是下标
                置 -1
                跳到此下标的新位置，继续 while 循环
                不小于 0 则继续
                否则继续 for 循环
                最后哪个下标上的值不是 -1
                则此下标的值是数组消失的数
             */
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
}
