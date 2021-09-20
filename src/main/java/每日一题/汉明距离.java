package 每日一题;

/**
 * Title: 汉明距离
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-27
 */
public class 汉明距离 {
    public int hammingDistance(int x, int y) {
//        int res = 0;
//        for (int i = 0; i < 31; i++) {
//            int x1 = x & 1;
//            int y1 = y & 1;
//            x = x >> 1;
//            y = y >> 1;
//            if (x1 != y1) {
//                res++;
//            }
//        }
//        return res;
//
//        int sum = x ^ y;
//        int res = 0;
//        while (sum != 0) {
//            res += sum & 1;
//            sum >>= 1;
//        }
//        return res;


        int sum = x ^ y;
        int res = 0;
        while (sum != 0) {
            sum &= sum - 1;
            res++;
        }
        return res;

    }
}
