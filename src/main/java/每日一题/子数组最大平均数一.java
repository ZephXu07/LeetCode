package 每日一题;

/**
 * Title: 子数组最大平均数一
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-04
 */
public class 子数组最大平均数一 {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int[] pre = new int[len + 1];
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int low = 0;
        int high = k;
        double res = Integer.MIN_VALUE;
        while (high <= len) {
            double tmp = (double) (pre[high] - pre[low]);
            res = Math.max(tmp, res);
            high++;
            low++;
        }
        return res / k;
    }

    public static void main(String[] args) {
        子数组最大平均数一 res = new 子数组最大平均数一();
        int[] nums =
                {8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
        int k = 93;
        System.out.println(res.findMaxAverage(nums, k));
    }
}
