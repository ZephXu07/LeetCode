package codetop;

/**
 * Title: 环形子数组的最大和918
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 环形子数组的最大和918 {
//    public int maxSubarraySumCircular(int[] nums) {
//        int len = nums.length;
//        if (len == 1) {
//            return nums[0];
//        }
//        int sum = nums[0];
//        /*
//            数组的和
//         */
//        int max = nums[0];
//        /*
//            数组的最大连续子数组的和
//            普通的，不是连续的
//         */
//        int dp = nums[0];
//        /*
//            每遍历到 nums[i] 时以 nums[i] 结尾的最大连续子数组的和
//         */
//        for (int i = 1; i < len; i++) {
//            sum += nums[i];
//            dp = Math.max(dp, 0) + nums[i];
//            max = Math.max(dp, max);
//        }
//
//        int mid = nums[1];
//        int min = nums[1];
//
//        for (int i = 2; i < len - 1; i++) {
//            mid = nums[i] + Math.min(0, mid);
//            min = Math.min(mid, min);
//        }
//        /*
//            同理上面，求除去首尾元素的最小子序和
//            用整个数组的和，减去此最小和
//            得到的则是 [0,i] [j,len -1]的最大和
//
//            再与上面普通做法进行对比
//         */
//
//        return Math.max(max, sum - min);
//
//
//    }

    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int sum = nums[0];
        /*
            数组的和
         */
        int max = nums[0];
        /*
            数组的最大连续子数组的和
            普通的，不是连续的
         */
        int dp = nums[0];
        /*
            每遍历到 nums[i] 时以 nums[i] 结尾的最大连续子数组的和
         */

        int mid = nums[1];
        int min = nums[1];

        for (int i = 1; i < len; i++) {
            sum += nums[i];
            dp = Math.max(dp, 0) + nums[i];
            max = Math.max(dp, max);

            if (i >= 2 && i < len - 1) {
                mid = nums[i] + Math.min(0, mid);
                min = Math.min(mid, min);
            }
        }

        /*
            同理上面，求除去首尾元素的最小子序和
            用整个数组的和，减去此最小和
            得到的则是 [0,i] [j,len -1]的最大和

            再与上面普通做法进行对比


         */

        return Math.max(max, sum - min);


    }

    public static void main(String[] args) {
        环形子数组的最大和918 res = new 环形子数组的最大和918();
        System.out.println(res.maxSubarraySumCircular(new int[]{5, -3, 5}) + "\t10");
        System.out.println(res.maxSubarraySumCircular(new int[]{1,-2,3,-2}) + "\t3");
        System.out.println(res.maxSubarraySumCircular(new int[]{3,-1,2,-1}) + "\t4");
        System.out.println(res.maxSubarraySumCircular(new int[]{3,-2,2,-3}) + "\t3");
    }
}
