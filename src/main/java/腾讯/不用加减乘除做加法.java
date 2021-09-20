package 腾讯;

/**
 * Title: 不用加减乘除做加法
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        /* 不计算进位相加的值 + 进位的值相加
           不计算进位相加的值：使用异或代替相加，相同为0，不同为1
            进位的值： 用与 &计算，两个为1则为1，因此产生进位，此时进位要左移一位，右边补0
            两个相加回到题目了，不使用加法代替，于是再次计算
            什么时候停止？等到b（进位的值）完全为0，则此时无需再加，
            返回a（存储不进位相加的值，再存储与进位相加的结果）
         */
        while (b != 0) {
            int tempSum = a ^ b;
            int carrySum = (a & b) << 1;
            a = tempSum;
            b = carrySum;
        }
        return a;

    }
}
