package 每日一题;

/**
 * Title: 数字的补数476
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-18
 */
public class 数字的补数476 {
    public int findComplement(int num) {
        int high = 0;
        /*
            2^x < n < 2^(x+1)
            x即是最高位
         */
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                high = i;
            } else {
                break;
            }
        }
        int mask = (1 << (high + 1)) - 1;
        /*
            掩码，即 0-high 全 1
            直接异或
         */
        return num ^ mask;
    }

    public static void main(String[] args) {
        数字的补数476 res = new 数字的补数476();
        System.out.println(res.findComplement(5));
    }
}
