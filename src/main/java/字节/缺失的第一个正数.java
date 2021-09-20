package 字节;

import java.util.Arrays;

/**
 * Title: 缺失的第一个正数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-21
 */
public class 缺失的第一个正数 {
    public int firstMissingPositiveNlogN(int[] nums) {
        Arrays.sort(nums);
        //从小到大排序
        int inx = 0;
        while (inx < nums.length && nums[inx] <= 0) {
            inx++;
        }
        //找到第一个正整数
        if (inx == nums.length) {
            return 1;
            //遍历结束，没有正整数，返回1
        } else {
            int start = 1;
            while (inx < nums.length && nums[inx] == start) {
                start++;
                inx++;
                //从1开始递增遍历，相等则下一个
                while (inx < nums.length && nums[inx] == nums[inx - 1]) {
                    inx++;
                    //存在重复则继续跳过
                }
            }
            return start;
            //返回第一个不等的
        }
    }

    public int firstMissingPositive(int[] nums) {
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] <= 0) {
//                nums[i] = len + 1;
//            }
//        }
//        for (int i = 0; i < len; i++) {
//            int val = Math.abs(nums[i]);
//            if (val <= len) {
//                nums[val - 1] = -Math.abs(nums[val - 1]);
//            }
//        }
//        for (int i = 0; i < len; i++) {
//            if (nums[i] > 0) {
//                return i + 1;
//            }
//        }
//        return len + 1;

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //当值大于0且小于等于n，因为题目要求的缺失的第一个正整数，即从1到数组长度n，
                // 当值不等于下标-1的数组元素的值，即元素不在其从1递增的顺序时要置换，
                // 例如1应该放在下标为0的地方，且当调整为原位时可能造成循环则跳出，
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            //完全归位
        }
        for (int i = 0; i < n; ++i) {
            //当值不等于下标+1时则是第一个缺少的正数
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
        缺失的第一个正数 res = new 缺失的第一个正数();
//        int[] nums = {1,2,0};
//        int[] nums = {3,4,-1,1};
//        int[] nums = {7,8,9,11,12};
//        int[] nums = {0,2,2,1,1};
//        int[] nums = {2,2};
        int[] nums = {3,4,-1,1};
        System.out.println(res.firstMissingPositive(nums));
        int[] nums1 = {3,4,-1,1};
        System.out.println(res.firstMissingPositiveNlogN(nums1));
    }
}
