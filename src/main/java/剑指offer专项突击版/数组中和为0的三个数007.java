package 剑指offer专项突击版;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: 数组中和为0的三个数007
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 数组中和为0的三个数007 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tmp = twoSum(nums, i + 1, 0 - nums[i]);
            for (int j = 0; j < tmp.size(); j++) {
                List<Integer> t = tmp.get(j);
                t.add(nums[i]);
                res.add(t);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i ++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums,int start, int target) {
        int low = start;
        int high = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
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
        return res;
    }
}
