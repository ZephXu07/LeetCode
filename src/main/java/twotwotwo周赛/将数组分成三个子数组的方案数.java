package twotwotwo周赛;

import java.util.LinkedList;

/**
 * Title: 将数组分成三个子数组的方案数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-03
 */
public class 将数组分成三个子数组的方案数 {
    public int waysToSplit(int[] nums) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        int[] prefix = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        // 返回值 ret
        long ret = 0;
        int mod = (int) (1e9 + 7);

         // i, l, r, ll, rr代表的是划分数组后此数组的右边界的下一个值下标
        for(int i = 1; i < len; i++) {
            // 特判：r >= m >= l，即使全相等前缀和也是三倍大，所以
            if(prefix[i] * 3 > prefix[len]) {
                break;
            }

            // 第一次二分找右边界
            int l = i + 1, r = len - 1;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(prefix[len] - prefix[mid] < prefix[mid] - prefix[i]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            // 第二次二分找左边界
            int ll = i + 1, rr = len - 1;
            while(ll <= rr) {
                int mid = ll + (rr - ll) / 2;
                if(prefix[mid] - prefix[i] < prefix[i]) {
                    ll = mid + 1;
                } else {
                    rr = mid - 1;
                }
            }
            ret += l - ll;
        }
        return (int)(ret % mod);


    }




    public static void main(String[] args) {
        int[] nums = {1,1,1};
        将数组分成三个子数组的方案数 res = new 将数组分成三个子数组的方案数();
//        System.out.println(res.waysToSplit(nums));
    }




}
