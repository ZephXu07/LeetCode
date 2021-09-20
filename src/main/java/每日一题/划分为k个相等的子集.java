package 每日一题;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Title: 划分为k个相等的子集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-05
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
        int tmp;
        int j = len - 1;
        for (int i = 0; i < len / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[j - i];
            nums[j - i] = tmp;
        }
        int[] bucket = new int[k];
        int target = sum / k;
        return backtrack(nums, bucket, target, 0);
    }

    private boolean backtrack(int[] nums, int[] bucket, int target, int inx) {
        if (inx == nums.length) {
            for (int j : bucket) {
                if (j != target) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[inx] > target) {
                continue;
            }
            bucket[i] += nums[inx];
            if (backtrack(nums, bucket, target, inx + 1)) {
                return true;
            }
            bucket[i] -= nums[inx];
        }
        return false;
    }


    //*********************************************************************************************

    public boolean canPartitionKSubsets(int k, int[] nums) {
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
        int tmp;
        int j = len - 1;
        for (int i = 0; i < len / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[j - i];
            nums[j - i] = tmp;
        }
        int target = sum / k;
        boolean[] used = new boolean[len];
        return backtrack(k, 0, nums, target, 0, used);
    }

    private boolean backtrack(int k, int bucket, int[] nums, int target, int start, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            return backtrack(k - 1, 0, nums, target, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (bucket + nums[i] > target) {
                continue;
            }
            bucket += nums[i];
            used[i] = true;
            if (backtrack(k, bucket, nums, target, i + 1, used)) {
                return true;
            }
            bucket -= nums[i];
            used[i] = false;
        }
        return false;
    }
}
