package codetop;

/**
 * Title: 回文数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-01
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int y = x;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return y == res;
    }

    public static void main(String[] args) {
        回文数 res = new 回文数();
        System.out.println(res.isPalindrome(121));
    }
}
