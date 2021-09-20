package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 获取生成数组中的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-23
 */
public class 获取生成数组中的最大值 {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                nums[i] = nums[i / 2];
            } else {
                int tmp = i / 2;
                nums[i] = nums[tmp] + nums[tmp + 1];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        获取生成数组中的最大值 res = new 获取生成数组中的最大值();
        System.out.println(res.getMaximumGenerated(7));
    }
}
