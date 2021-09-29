package 每日一题;

/**
 * Title: 两整数之和371
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-28
 */
public class 两整数之和371 {
//    public int getSum(int a, int b) {
//        int res = 0;
//        int c = 0;
//        for (int i = 0; i < 32; i++) {
//            int b1 = (a >> i) & 1;
//            int b2 = (b >> i) & 1;
//            if (b1 == 1 && b2 == 1) {
//                /*
//                    此时进位，如果前一位有进位 c 则为 1
//                    否则为 0
//                    此刻的进位 c 必为 1
//                 */
//                res |= c << i;
//                c = 1;
//            } else if (b1 == 1 || b2 == 1){
//                /*
//                    只有一个为 1
//                    如果前一个进位 c 为 1
//                    则此时异或取 0，则又有进位 c = 1
//                    否则c = 0，取 1， c = 0
//                    c 不变
//                 */
//                res |= (1 ^ c) << i;
//            } else {
//                /*
//                    两个都为 0
//                    看 c 是否为 1
//                    c 之后一定为 0
//                 */
//                res |= c << i;
//                c = 0;
//            }
//        }
//        return res;
//    }

    public int getSum(int a, int b) {
        /*
            a ^ b 是无进位的和
            a & b 不为 0 表示存在进位，进位则是需要在左边一位，所以左移
            再用无进位的和 与 进位再次计算
            直到进位为 0
         */
        int c;
        while (b != 0) {
            c = (a & b) << 1;
            a ^= b;
            b = c;
        }

        return a;
    }
}
