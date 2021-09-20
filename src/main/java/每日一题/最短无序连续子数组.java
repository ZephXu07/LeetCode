package 每日一题;

import java.util.Arrays;

/**
 * Title: 最短无序连续子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-03
 */
public class 最短无序连续子数组 {
//    private boolean asc;
//    public boolean desc;
//    public int findUnsortedSubarray(int[] nums) {
//        int len = nums.length;
//        if (len == 1) {
//            return 0;
//        }
//        asc = false;
//        desc = false;
//        isOrder(nums);
//        if (asc) {
//            return 0;
//        }
//        if (desc) {
//            return len;
//        }
//        int[] sort = new int[len];
//        System.arraycopy(nums, 0, sort, 0, len);
//        Arrays.sort(sort);
//        int left = 0;
//        while (left < len && nums[left] == sort[left]) {
//            left++;
//        }
//        int right = len - 1;
//        while (right >= 0 && nums[right] == sort[right]) {
//            right--;
//        }
//        return right - left + 1;
//    }
//
//    private void isOrder (int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] <= nums[i]) {
//                asc = true;
//            } else {
//                asc = false;
//                break;
//            }
//        }
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] >= nums[i]) {
//                desc = true;
//            } else {
//                desc = false;
//                break;
//            }
//        }
//    }

    public int findUnsortedSubarray(int[] nums) {
        /*
            A B C
            A 递增有序
            B 混乱无序，需要排序
            C 递增有序

            A的最大值小于等于 B的最小值，否则A也在B里面，A可能不存在，即长度为 0
            C的最小值大于等于 B的最大值，否则C也在B里面，C可能不存在，即长度为 0
         */
        int len = nums.length;
        if (len == 1) {
            return 0;
            /*
                数组长度为1自然不需要排序
             */
        }
        int max = Integer.MAX_VALUE;
        int left = -1;
        /*
           max  A 的最大值，即 B 的最小值
           left B 的左边界
         */

        int min = Integer.MIN_VALUE;
        int right = -1;
        /*
            min C 的最小值，即 B 的最大值
            right B 的右边界
         */
        for (int i = 0; i < len; i++) {
            if (max >= nums[len - 1 - i]) {
                max = nums[len - 1 - i];
            } else {
                left = len - 1 - i;
            }
            /*
                从右往左遍历
                因为 C 的最小值 大于等于 B 的最大值，
                B 的最小值 大于等于 A 的最大值
                C 从右往左是递减，如果发现是递减的，说明还在C里面
                即不在 B和 A里面，继续寻找 C 的最小值
                进入 B 之后，由于 B 无序，
                所以 left 会变化多次，直到 A 与 B 的边界，此时找到 B 中最小值
                由于 B 的最小值大于 A 的最大值，所以在A与B交界处
                B[0] > A 的末尾，即 B[0] > max
                如 2 6 4 5
                4 为 max ，6 > 4
                如 2 6 2 5
                2 为 max，6 > 2
                如 2 2 2 5 如 2 4 4 5
                A 的范围便扩大了

                所以此处 left 更新为 B[0] 的下标

             */

            if (min <= nums[i]) {
                min = nums[i];
            } else {
                right = i;
            }
            /*
                从左往右遍历，A 、B 的最大值是 C的最小值
                在 A 中是递增的，min 不断增大，到达 A 的最大值
                进入 B ，A 的最大值小于等于 B 的最小值，所以 right 开始变化了
                当在 B 中从大变小时，right 变化了
                在 B 与 C 交界处，B[len - 1] < C[0]，right = B 的 len - 1
                 min 会取得 B 中的最大值
                 此时 B[len - 1] 也会小于 min
                 如 2 6 4 8 10 9 15 min = 10，right = 9 下标
                 如果 B[len - 1] 等于 min
                 如 2 6 4 8 10 10 15 min = 6，right = 4 下标
                 此时 C 的范围增大了，B 是 6 4 ，min = 6，B[len - 1] = 4 还是小于 8

                 所以 right - left + 1 这个长度范围的数是需要排序的

                 再如 2 4 4 8 10 10 15  B 消失了，right = - 1
                 完全不需要排序，返回 0

                 如果 15 10 10 8 4 4 2
                 max = 15， left = 0
                 min = 15，right = 6
                 right - left + 1 =  7 ，完全数组的长度
             */


        }

        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        最短无序连续子数组 res = new 最短无序连续子数组();
        System.out.println(res.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}) + "\t5");
        System.out.println(res.findUnsortedSubarray(new int[]{1,2,3,4}) + "\t0");
        System.out.println(res.findUnsortedSubarray(new int[]{1}) + "\t0");
        System.out.println(res.findUnsortedSubarray(new int[]{1,2,3,3,3})+ "\t0");
        System.out.println(res.findUnsortedSubarray(new int[]{1,3,2,2,2}) + "\t4");
        System.out.println(res.findUnsortedSubarray(new int[]{3,2,3,2,4}) + "\t4");
        System.out.println(res.findUnsortedSubarray(new int[]{5,4,3,2,1}) + "\t5");
        System.out.println(res.findUnsortedSubarray(new int[]{2,3,3,2,4}) + "\t3");
        System.out.println(res.findUnsortedSubarray(new int[]{2,1,1,1,1}) + "\t5");
        System.out.println(res.findUnsortedSubarray(new int[]{1,3,2}) + "\t2");
        System.out.println(res.findUnsortedSubarray(new int[]{1,3,5,4,2}) + "\t4");
    }
}
