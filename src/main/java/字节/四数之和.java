package 字节;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: 四数之和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-23
 */
public class 四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int nLen = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || nLen < n) {
            return res;
        }
        if (2 == n) {
            int low = start;
            int high = nLen - 1;
            List<Integer> tmp;
            while (low < high) {
                int sum = nums[low] + nums[high];
                int left = nums[low];
                int right = nums[high];
                if (sum < target) {
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                } else if (sum > target) {
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                } else {
                    tmp = new ArrayList<>();
                    tmp.add(left);
                    tmp.add(right);
                    res.add(tmp);
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                }
            }
        } else {
            for (int i = start; i < nLen; i++) {
                List<List<Integer>> tmp = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (int j = 0; j < tmp.size(); j++) {
                    List<Integer> t = tmp.get(j);
                    t.add(nums[i]);
                    res.add(t);
                }
                while (i < nLen - 1 && nums[i] == nums[i + 1]) {
                    i ++;
                }
            }
        }
        return res;
    }
}
