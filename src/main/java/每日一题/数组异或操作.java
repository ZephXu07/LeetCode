package 每日一题;

/**
 * Title: 数组异或操作
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-07
 */
public class 数组异或操作 {
//    public int xorOperation(int n, int start) {
//        int res = start;
//        for (int i = 1; i < n; i++) {
//            res ^= start + 2 * i;
//        }
//        return res;
//    }

    public int xorOperation(int n, int start) {
        /*
            (start) ^ (start + 2) ^ (start + 4) ^ (start + 6) ^ ... ^ (start + 2(n - 1))
            当 start 偶数时 2
                n 奇数时 3      n 偶数时 4
            2   0010            0010
            4   0100            0100
            6   0110            0110
                            8   1000

                0000            1000
            当 start 偶数时最后一位永远为 0

            当 start 奇数时 3
                n 奇数时 3      n 偶数时 4
            3   0011            0011
            5   0101            0101
            7   0111            0111
                            9   1001

                0001            1000

             当 start 奇数时，n 奇数则最后一位 1
                            n 偶数则最后一位 0

            于是设最后一位为 b0
            设 s = start / 2
            则上述式子转为：
            (s) ^ (s + 1) ^ (s + 2) ^ (s + 3) ^ ... ^ (s + (n - 1)) * 2 + b0
            (提出2来为什么等式成立我也不知道，代数值进去他成立我能怎么办)

            对[0,n]进行异或操作，即 0^1^2^3...^n
            n   二进制     异或二进制
            0   0000        0000
            1   0001        0001
            2   0010        0011
            3   0011        0000

            4   0100        0100
            5   0101        0001
            6   0110        0111
            7   0111        0000

            发现 n % 4 == 0 时，异或结果是 n
            发现 n % 4 == 1 时，异或结果是 1
            发现 n % 4 == 2 时，异或结果是 n + 1
            发现 n % 4 == 3 时，异或结果是 0

            则有定义 sumXor = n           n % 4 == 0
                            1           n % 4 == 1
                            n + 1       n % 4 == 2
                            0           n % 4 == 3
            所以：
            (s) ^ (s + 1) ^ (s + 2) ^ (s + 3) ^ ... ^ (s + (n - 1)) * 2 + b0
            化简为：

    (0^1^2^...^(s - 1)) ^ (0^1^2^...^(s - 1)^(s) ^ (s + 1) ^ (s + 2) ^ (s + 3) ^ ... ^ (s + (n - 1)))
  = ( 0^1^2^...^(s - 1) ) ^ ( 0^1^2^...^(s - 1) ) ^  (s) ^ (s + 1) ^ (s + 2) ^ (s + 3) ^ ... ^ (s + (n - 1))
    这两个相同为0
  = sumXor(s - 1) ^ sumXor(s + (n - 1))
         */


            int s = start  /  2;
            int b0  = n & start & 1;
            int ret = sumXor(s - 1) ^ sumXor(s + n - 1);
            return (ret * 2) | b0;
        }

    public int sumXor(int n) {
            if (n % 4 == 0) {
                return n;
            }
            if (n % 4 == 1) {
                return 1;
            }
            if (n % 4 == 2) {
                return n + 1;
            }
            return 0;
    }


}
