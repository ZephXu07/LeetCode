package codetop;

/**
 * Title: 大小为K且平均值大于等于阈值的子数组数目
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 大小为K且平均值大于等于阈值的子数组数目 {
//    public int numOfSubarrays(int[] arr, int k, int threshold) {
//        int len = arr.length;
//        if (len < k) {
//            return 0;
//        }
//        int[] pre = new int[len + 1];
//        for (int i = 0; i < len; i++) {
//            pre[i + 1] = pre[i] + arr[i];
//        }
//
//        int res = 0;
//        for (int i = 0; i <= len - k; i++) {
//            if ((pre[i + k] - pre[i]) / (double)k >= threshold) {
//                res++;
//            }
//        }
//
//        return res;
//
//    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        if (len < k) {
            return 0;
        }
        int target = k * threshold;
        int sum = 0;

        int res = 0;

        for (int i = 0; i < k; i++) {
            /*
                [0,k-1] 个
             */
            sum += arr[i];
        }

        if (sum >= target) {
            /*
                提前判断
             */
            res = 1;
        }

        for (int i = k; i < len; i++) {
            sum = sum + arr[i] - arr[i - k];
            /*
                i 为右边，添加
                i - k 为左边，减去
             */
            if (sum >= target) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        大小为K且平均值大于等于阈值的子数组数目 res = new 大小为K且平均值大于等于阈值的子数组数目();
        System.out.println(res.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(res.numOfSubarrays(new int[]{1,1,1,1,1}, 1, 0));
        System.out.println(res.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5));
    }
}
