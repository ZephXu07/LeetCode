package 杂类;

/**
 * Title: 递增的三元子序列334
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-20
 */
public class 递增的三元子序列334 {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) {
                /*
                    当出现 1 1 2 之类的如果没有 "=" 会使 mid 重置为 1

                    而如果有 3 5 1 6
                    时即使 3 被替换为 1 ，但始终存在 1 < 3 < 5，没有差错
                    而如果 3 5 1 2 3
                    此时 3 --> 1
                        5 --> 2
                    程序也正常
                 */
                min = n;
            } else if (n < mid) {
                mid = n;
            } else if (n > mid) {
                return true;
            }
        }
        return false;
    }
}
