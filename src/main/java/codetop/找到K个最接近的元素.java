package codetop;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Title: 找到K个最接近的元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 找到K个最接近的元素 {
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        /*
//            滑动窗口
//            因为数组为正整数，且从小到大排序了
//            所以与 x 的差值的绝对值是递增的
//            无论 x 正负
//         */
//        int len = arr.length;
//        int diff = 0;
//        for (int i = 0; i < k; i++) {
//            diff += Math.abs(arr[i] - x);
//            /*
//                预先填充 k 个
//             */
//        }
//        int left = 0;
//        int right = k;
//        int min = diff;
//        /*
//            记录最小的 k 个
//            与起始位置
//         */
//        while (right < len) {
//            diff -= Math.abs(arr[right - k] - x);
//            diff += Math.abs(arr[right] - x);
//            /*
//                加右减左
//             */
//            if (diff < min) {
//                /*
//                    找到更小的
//                    说明这 k 个数与 x 更接近
//                    记录起始位置
//                 */
//                diff = min;
//                left = right - k + 1;
//            }
//            right++;
//        }
//        List<Integer> res = new ArrayList<>(k);
//        for (int i = 0; i < k; i++) {
//            res.add(arr[left + i]);
//        }
//
//        return res;
//    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        List<Integer> res = new ArrayList<>(k);
        if (arr[0] >= x) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        } else if (arr[len - 1] <= x) {
            for (int i = len - k; i < len; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        int left = 0;
        int right = len - k;
        /*
            二分枚举这 k 个数的左边界
            l                      m          m + k     x     r
            |______________________|____________|______|______|
           l = m + 1

           l             x         m          m + k          r
            |___________|___________|____________|____________|
           r = m

           l                      m       x   m + k          r
            |______________________|______|______|____________|
            此时 [m,m+k] 小于 [m+1+k,m+1+k]
            r = m

            l                      m      |   x  m + k          r
            |______________________|______|___|___|____________|
            此时 m + k 比 m 还近于 x
            所以 l = m + 1

            l                      m  x    |     m + k          r
            |______________________|__|____|______|____________|
            r = m

         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] <= arr[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(arr[left + i]);
        }
        return res;
    }
}
