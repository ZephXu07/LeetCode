package codetop;

import java.util.Arrays;

/**
 * Title: 划分为k个相等的子集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 划分为k个相等的子集 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        if (k > len) {
            return false;
        }
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;
        boolean[] visited = new boolean[len];
        return backtrack(k, 0, nums, target, 0, visited);
    }

    private boolean backtrack(int k, int sum, int[] nums, int target, int start, boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (sum == target) {
            return backtrack(k - 1, 0, nums, target, 0, visited);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || sum + nums[i] > target) {
                continue;
            }
            sum += nums[i];
            visited[i] = true;
            if (backtrack(k, sum, nums, target, i + 1, visited)) {
                return true;
            }
            sum -= nums[i];
            visited[i] = false;
        }
        return false;
    }
}
