package 每日一题;

/**
 * Title: 整数反转
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-03
 */
public class 整数反转 {
    public int reverse(int x) {
        /*
            按照题目要求，超过32位有符号数范围则返回0，
            计算之前先判断是否溢出int范围，
            ans * 10 若溢出了，再除以 10 肯定不是原来的ans，所以判断溢出了，于是直接返回0
            其他的计算则是很简单
         */
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
