package codetop;

import java.util.Arrays;

/**
 * Title: 比特位计数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 比特位计数 {
//    public int[] countBits(int num) {
//        /*
//            最普通的
//         */
//        int[] res = new int[num + 1];
//        for (int i = 1; i <= num; i++) {
//            res[i] = getBit(i);
//        }
//        return res;
//    }
//
//    private int getBit(int val) {
//        int count = 0;
//        while (val > 0) {
//            val &= (val - 1);
//            //抹除最低位的1
//            count ++;
//        }
//        return count;
//    }

//     public int[] countBits(int num) {
//         int[] res = new int[num + 1];
//         /*
//            类似动态规划
//            dp[偶数] = dp[偶数 / 2]
//            2 - 4 - 8
//            6 - 12
//            dp[奇数] = dp[奇数 / 2] + 1
//
//            3 - 2(+1) - 1
//          */
//         for (int i = 1; i <= num; i++) {
//             if ((i & 1) == 0) {
//                 res[i] = res[i / 2];
//             } else {
//                 res[i] = res[i - 1] + 1;
//             }
//             //奇数：比一个的偶数多1
//             //偶数：与一个的偶数相等
//         }
//         return res;
//     }

//     public int[] countBitsThree(int num) {
//         /*
//            动态规划
//            2(10) -> 0(00)+1
//            5(101) -> 1(001)+1
//          */
//         int[] bits = new int[num + 1];
//         for (int i = 1; i <= num; i++) {
//             bits[i] = bits[i & (i - 1)] + 1;
//             //i & (i - 1)的值是i的最低位1置0，所以 + 1则是i的比特位数
//         }
//         return bits;
//     }


     public int[] countBits(int num) {
         int[] bits = new int[num + 1];
         int highBit = 0;
         for (int i = 1; i <= num; i++) {
             if ((i & (i - 1)) == 0) {
                 highBit = i;
             }
             bits[i] = bits[i - highBit] + 1;
             /*
                i           i-1          hB         bits
                1(01)       0(00)       1             [0]+1=1
                2(10)       1(01)       2             [0]+1=1
                3(11)       2(10)       2             [1]+1=2
                4(100)      3(011)      4             [0]+1=1

                得到小于 i 的最大的2的幂的数，




              */
         }
         return bits;
     }

    public static void main(String[] args) {
        比特位计数 res = new 比特位计数();
        System.out.println(Arrays.toString(res.countBits(3)));
    }

}
