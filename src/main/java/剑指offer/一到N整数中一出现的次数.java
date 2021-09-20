package 剑指offer;

/**
 * Title: 一到N整数中一出现的次数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-02
 */
public class 一到N整数中一出现的次数 {
    public int countDigitOne(int n) {
        int low = 0;
        int high = n / 10;
        int cur = n % 10;
        int digit = 1;
        int count = 0;
        while (0 != high || 0 != cur) {
            if (0 == cur) {
                count += high * digit;
            } else if (1 == cur) {
                count += high * digit + low + 1;
            } else {
                count += high * digit + digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        一到N整数中一出现的次数 res = new 一到N整数中一出现的次数();
        System.out.println(res.countDigitOne(1));
        System.out.println(res.countDigitOne(12));
        System.out.println(res.countDigitOne(13));
        System.out.println(res.countDigitOne(14));
    }
}
