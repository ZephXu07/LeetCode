package 每日一题;

import java.util.Arrays;

/**
 * Title: 比特位计数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-03
 */
public class 比特位计数 {
    public int[] countBitsOne(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = getBit(i);
        }
        return res;
    }

    private int getBit(int val) {
        int count = 0;
        while (val > 0) {
            val &= (val - 1);
            //抹除最低位的1
            count ++;
        }
        return count;
    }


    public int[] countBitsTwo(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
            //奇数：比一个的偶数多1
            //偶数：与一个的偶数相等
        }
        return res;
    }

    public int[] countBitsThree(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
            //i & (i - 1)的值是i的最低位1置0，所以 + 1则是i的比特位数
        }
        return bits;
    }


    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
            //以8为例，二进制表示是1 0 0 0，
            // 那么从8到15的过程中，最高位始终是1，
            // 只有后三位从0 0 0到1 1 1在变化，所以得到差的比特位数 + 1就是所求的比特位数
            // 这就是为什么会有 bits[i] = 1 + bits[i - highBit]
        }
        return bits;
    }


    public static void main(String[] args) {
        比特位计数 res = new 比特位计数();
        int num = 5;
        System.out.println(Arrays.toString(res.countBitsOne(num)));
        System.out.println(Arrays.toString(res.countBitsTwo(num)));
    }
}
