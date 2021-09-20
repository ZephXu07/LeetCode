package 每日一题;

import labuladong.Solution;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Title: 绝对差值和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-14
 */
public class 绝对差值和 {
    public static int minAbsoluteSumDiff0(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int len = nums1.length;
        int[] pre = new int[len + 1];
        for (int i = 0; i < len; i++) {
            pre[i + 1] = (pre[i] + Math.abs(nums1[i] - nums2[i])) % mod;
        }
        int res = pre[len];
        for (int i = 0; i < len; i++) {
            int other = pre[len] - (pre[i + 1] - pre[i]);
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int tmp = (other + Math.abs(nums1[j] - nums2[i])) % mod;
                res = Math.min(tmp, res);
            }
        }
        return res;
    }

    public static int minAbsoluteSumDiff1(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int len = nums1.length;
        long pre = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums1[i]);
            pre += Math.abs(nums1[i] - nums2[i]);
        }
        long res = pre;
        for (int i = 0; i < len; i++) {
            long other = pre - Math.abs(nums1[i] - nums2[i]);
            Integer floor = set.floor(nums2[i]);
            Integer ceiling = set.ceiling(nums2[i]);

            if (null != floor) {
                long tmp = (other + Math.abs(floor - nums2[i]));
                res = Math.min(tmp, res);
            }
            if (null != ceiling) {
                long tmp = (other + Math.abs(ceiling - nums2[i]));
                res = Math.min(tmp, res);
            }
        }
        return (int)(res % mod);
    }

    public  int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            /*
                取全部的绝对值的和
                找到 nums1 中最接近 nums2[i] 的值，
                这个值可能在二分查找过程中的 mid-1/mid/mid+1 中出现，
                为了不侵入二分查找，可以转化为「找到 nums1 中大于等于 nums2[i] 的最小下标 j，
                那么该值可能在 j（j < n） 或 j-1（j > 0）
             */
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
        /*
        遍历过程中使用了取模操作，
        可能会导致最终 sum < maxn，
        因此结果要使用 (sum - maxn + mod) % mod 的形式
         */
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        /*
            nums2[]的值已经已经比 nums1 中所有值大，
            于是返回长度，即将被取的是 nums[len - 1]
         */
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,7,5};
//        int[] nums2 = {2,3,5};
//        int[] nums1 = {2,4,6,8,10};
//        int[] nums2 = {2,4,6,8,10};
        int[] nums1 = {1,10,4,4,2,7};
        int[] nums2 = {9,3,5,1,7,4};

        System.out.println(minAbsoluteSumDiff0(nums1, nums2));
        System.out.println(minAbsoluteSumDiff1(nums1, nums2));
    }
}
