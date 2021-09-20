package codetop;

import labuladong.Solution;

/**
 * Title: n的第k个因子
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-06
 */
public class n的第k个因子 {
//    public int kthFactor(int n, int k) {
//        int count = 0;
//        for (int fac = 1; fac <= n; ++fac) {
//            if (n % fac == 0) {
//                ++count;
//                if (count == k) {
//                    return fac;
//                }
//            }
//        }
//        return -1;
//    }

//    public int kthFactor(int n, int k) {
//        int count = 0, fac;
//        for (fac = 1; fac * fac <= n; ++fac) {
//            if (n % fac == 0) {
//                ++count;
//                if (count == k) {
//                    return fac;
//                }
//            }
//        }
//        --fac;
//        /*
//            因为超过了才到这
//         */
//        if (fac * fac == n) {
//            /*
//                完全平分需要减 1
//             */
//            --fac;
//        }
//        for (; fac > 0; --fac) {
//            if (n % fac == 0) {
//                ++count;
//                if (count == k) {
//                    /*
//                        逆向寻找
//                     */
//                    return n / fac;
//                }
//            }
//        }
//        return -1;
//        /*
//            找不到
//         */
//    }


}
