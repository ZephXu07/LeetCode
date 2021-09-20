package 字节;

/**
 * Title: 整数替换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-25
 */
public class 整数替换 {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                // 偶数直接右移
                n >>= 1;
            }else {
                // 奇数 01减一,11加1,特殊情况n=3也是减1
                n += ((n & 2) == 0 || n == 3)? -1 : 1;
            }
            count++;
        }
        return count;
    }
}
