package 每日一题;

/**
 * Title: 错误的集合
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-04
 */
public class 错误的集合 {
    public int[] findErrorNums(int[] nums) {
        /*  数组下标从 0 到 n - 1
            从 1 开始到 n ，出现一个重复的
            于是这可以进行对应
            遍历，值 - 1 代表一个下标，
            得到新的值，由题知道不是负数，将新的值取负数
            如果新的值是负数，说明刚刚已经遍历了，
            代表这新的值代表的 坐标 + 1 是重复发，即这个就是重复的数
         */
        int rep = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] >= 0) {
                nums[index] *= -1;
            } else {
                rep = Math.abs(nums[i]);
            }
        }
        int miss = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                miss = i + 1;
            }
        }
        return new int[]{rep, miss};
    }
}
