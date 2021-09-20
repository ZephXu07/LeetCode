package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 快乐数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-31
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = n;
        do {
            slow = nextNum(slow);
            fast = nextNum(fast);
            if (fast == 1) {
                return true;
            }
            fast = nextNum(fast);
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    private int nextNum (int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        快乐数 res = new 快乐数();
        System.out.println(res.isHappy(1));
        System.out.println(res.isHappy(19));
        System.out.println(res.isHappy(2));
    }
}
