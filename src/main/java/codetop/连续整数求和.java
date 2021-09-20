package codetop;

/**
 * Title: 连续整数求和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-18
 */
public class 连续整数求和 {
//    public int consecutiveNumbersSum(int n) {
//        int res = 0;
//        int tar;
//        int j;
//        for (int i = 1; i <= n; i++) {
//            tar = n;
//            j = i;
//            while (tar > 0) {
//                tar -= j;
//                j++;
//            }
//            res += tar == 0 ? 1 : 0;
//        }
//        return res;
//    }


    public int consecutiveNumbersSum(int n) {
        /*
            (x+1)+(x+2)+...+(x+k) = kx + k(k+1)/2 = N
            N - k(k+1)/2 = kx
            x >= 0，如果 N - k(k+1)/2 除以 k 得到的 x 非负整数
            即找到了一组解，x+1 ... x+k 的 k 组数即满足

            同时 kx + k(k+1)/2 = N
                2kx + k(k+1) = 2N
                k(2x+k+1) = 2N
                x >= 0
                所以 k < sqrt(2N)

                k 至少为 1，如果为 1 时，x = N - 1,即 x + 1 = N
         */
        int res = 0;
        int size = (int) Math.sqrt(2 * n);
        /*
            因为是向下取整的，所以需要 <=
         */
        for (int k = 1; k <= size; k++) {
            if ((n - k * (k - 1) / 2) % k == 0) {
                res++;
            }
        }
        return res;
    }
}
