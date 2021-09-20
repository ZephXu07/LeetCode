package 剑指offer;

/**
 * Title: 数字序列中某一位的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int digit = 1;
        long nshadow = n - 10;
        long start = 1;
        while (nshadow > 0) {
            digit ++;
            start *= 10;
            nshadow = nshadow - digit * 9 * start;
        }
        nshadow += digit * 9 * start;
        int which = (int)nshadow / digit;
        int index = (int)nshadow % digit;
        return String.valueOf(start + which).charAt(index) - '0';
    }

    public static void main(String[] args) {
        数字序列中某一位的数字 res = new 数字序列中某一位的数字();
        System.out.println(res.findNthDigit(2147483647));
    }
}
