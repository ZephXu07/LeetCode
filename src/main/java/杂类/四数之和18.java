package 杂类;

import labuladong.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 四数之和18
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-26
 */
public class 四数之和18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                /*
                    排除与前一个数相同的情况
                 */
                continue;
            }


            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                /*
                    确定了第一个数，因为是排序的，与其相邻的三个递增的数的和大于目标了
                    说明后面的数的和只会更大，因此停止
                 */
                break;
            }
            if (!(nums[i] + nums[length - 3] >= 2147483647 - nums[length - 2] - nums[length - 1])
                && (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target)) {
                 /*
                    专为测试例子提供的判断
                    确定了第一个数，因为是排序的，与其最后的三个最大的数的和小于目标了
                    说明第一个数太小了，停止
                 */
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    /*
                        排除与前一个数相同的情况
                     */
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    /*
                        确定了第一、二个数，因为是排序的，与其相邻的两个个递增的数的和大于目标了
                        说明后面的数的和只会更大，因此停止
                     */
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    /*
                        确定了第一、二个数，因为是排序的，与其最后的两个个最大的数的和小于目标了
                        说明第一个数太小了，停止
                     */
                    continue;
                }
                int left = j + 1, right = length - 1;
                /*
                    枚举三四
                    双指针
                 */
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            /*
                                排除第三个数重复
                             */
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            /*
                                排除第四个数重复
                             */
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        四数之和18 res = new 四数之和18();
        System.out.println(res.fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000));
    }
}
