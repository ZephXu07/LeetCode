package 每日一题;

/**
 * Title: 所有奇数长度子数组的和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 所有奇数长度子数组的和 {
//    public int sumOddLengthSubarrays(int[] arr) {
//        int len = arr.length;
//        int[] pre = new int[len + 1];
//        for (int i = 0; i < len; i++) {
//            pre[i + 1] = pre[i] + arr[i];
//        }
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            /*
//                起点
//             */
//            for (int j = 1; j + i - 1 < len; j += 2) {
//                /*
//                    长度
//                 */
////                for (int k = i; k < i + j; k++) {
////                    /*
////                        [k, i + j)
////                     */
//                    res += pre[i + j] - pre[i];
////                }
//            }
//        }
//        return res;
//    }

    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int res = 0;
        int left;
        /*
            i 左边选择数字个数的可能种类 0 1 2 ...
         */
        int right;
        /*
            i 右边选择数字个数的可能种类 0 1 2 ...
         */
        int leftEven;
        /*
            i 左边选择偶数个数字的可能种类 0 2 4
         */
        int rightEven;
        /*
            i 右边选择偶数个数字的可能种类 0 2 4
         */
        int leftOdd;
        /*
            i 左边选择奇数个数字的可能种类 1 3 5
         */
        int rightOdd;
        /*
            i 右边选择奇数个数字的可能种类 1 3 5
         */

        /*
            i 的左侧可能有 0 1 2 3 ... 个数字，即 left = i + 1
            其中偶数有 0 2 ... ，为 (left + 1) / 2
            其中奇数有 1 3 ... 为 left / 2

            i 的右侧可能有 0 1 2 3 ... 个数字，即 right = len - i
            其中偶数有 0 2 ... ，为 (right + 1) / 2
            其中奇数有 1 3 ... 为 right / 2

            奇数个数字 + arr[i] + 奇数个数字  x * y
            偶数个数字 + arr[i] + 偶数个数字  m * n

            使用乘法原理和加法原理  x * y + m * n

         */
        for (int i = 0; i < len; i++) {
            left = i + 1;
            right = len - i;
            leftEven = (left + 1) / 2;
            leftOdd = left / 2;
            rightEven = (right + 1) / 2;
            rightOdd = right / 2;

            res += (leftEven * rightEven +  leftOdd * rightOdd) * arr[i];
        }

        return res;
    }



    public static void main(String[] args) {
        所有奇数长度子数组的和 res = new 所有奇数长度子数组的和();
        System.out.println(res.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }
}
