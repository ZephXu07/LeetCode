package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 求众数II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-16
 */
public class 求众数II {
    public List<Integer> majorityElement(int[] nums) {
        /*
            出现超过 1 / 3 的次数，
            如果只有 nums 只有三个数，即出现次数为 num.len / 3
            所以最多只能有 2 个数出现次数超过 1 / 3的次数
         */
        int[] one = {nums[0], 0};
        int[] two = {nums[0], 0};

        for (int n : nums) {
            if (one[0] == n) {
                one[1]++;
                continue;
            }

            if (two[0] == n) {
                two[1]++;
                continue;
            }

            if (one[1] == 0) {
                one[0] = n;
                one[1] = 1;
                continue;
            }

            if (two[1] == 0) {
                two[0] = n;
                two[1] = 1;
                continue;
            }

            one[1]--;
            two[1]--;

        }
        one[1] = 0;
        two[1] = 0;
        for (int n : nums) {
            if (n == one[0]) {
                one[1]++;
            } else if (n == two[0]) {
                two[1]++;
            }
        }

        List<Integer> res = new LinkedList<>();
        if (one[1] > nums.length / 3) {
            res.add(one[0]);
        }
        if (two[1] > nums.length / 3) {
            res.add(two[0]);
        }

        return res;
    }
}
