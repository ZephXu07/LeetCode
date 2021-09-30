package 剑指offer专项突击版;

/**
 * Title: 前n个数字二进制中1的个数003
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 前n个数字二进制中1的个数003 {
//    public int[] countBits(int num) {
//        int[] res = new int[num + 1];
//         /*
//            类似动态规划
//            dp[偶数] = dp[偶数 / 2]
//            2 - 4 - 8
//            6 - 12
//            dp[奇数] = dp[奇数 / 2] + 1
//
//            3 - 2(+1) - 1
//          */
//        for (int i = 1; i <= num; i++) {
//            if ((i & 1) == 0) {
//                res[i] = res[i / 2];
//            } else {
//                res[i] = res[i - 1] + 1;
//            }
//            //奇数：比一个的偶数多1
//            //偶数：与一个的偶数相等
//        }
//        return res;
//    }

    public int[] countBits(int num) {
         /*
            动态规划
            2(10) -> 0(00)+1
            5(101) -> 1(001)+1
          */
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
            //i & (i - 1)的值是i的最低位1置0，所以 + 1则是i的比特位数
        }
        return bits;
    }
}
