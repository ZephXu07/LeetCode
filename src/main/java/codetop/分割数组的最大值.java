package codetop;

/**
 * Title: 分割数组的最大值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-21
 */
public class 分割数组的最大值 {
    public int splitArray(int[] nums, int m) {
        /*
            计算数组的最大值与总和
            连续子数组的和的最大值 [max,sum] 之中
            使用二分，预计出这个值，看看数组能切割多少个数组，如果切割数 count == m ，且在 low == high 时求出

            这个值一定在 [max,sum] 中，但一开始即使 count == m 也可能取不到，
            即最大值 max 可能不是一个连续子数组之和

            先切割为 [low,mid] [mid+1,high] 同时 max 越大，即 mid 越大，
            切割的连续子数组的个数越少，即 count 越小

            count == m
            时刚好在 mid ，而 mid 越大，count 越小，所以 mid 需要减小，high = mid，[left,mid]
            而 mid 越小，count 越大，所以 mid 需要增大，left = mid + 1，[mid + 1, high]

            同时直到 low + 1 = high 时，mid == low，
            此时已经逼近所求结果了，再 high = mid = left
            结束，即是结果

         */
        int[] maxAndSum = getMaxAndSum(nums);
        int low = maxAndSum[0];
        int high = maxAndSum[1];
        int mid;
        int count;
        while (low < high) {
            mid = low + (high - low) / 2;
            count = split(nums, mid);
            if (count <= m) {
                high = mid;
                // if (count == m) {
                //     high = mid;
                // } else if (count < m) {
                //     high = mid;
                // }
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int[] getMaxAndSum(int[] nums) {
        /*
            求数组的和与最大值
         */
        int max = 0;
        int sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        return new int[]{max, sum};
    }

    private int split(int[] nums, int max) {
        /*
            nums[] 切割，最大值是 max，连续子数组的和不能超过 max
           一共可以切割成多少个连续子数组
         */
        int count = 1;
        int sum = 0;
        for (int n : nums) {
            if (sum + n > max) {
                /*
                    连续子数组超过 max
                    一个分组了，n是下一个分组的
                 */
                count ++;
                sum = n;
            } else {
                sum += n;
            }
        }
        return count;
    }
}
