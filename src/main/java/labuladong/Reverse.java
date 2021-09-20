package labuladong;

/**
 * Title: labuladong.Reverse
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-13
 */
public class Reverse {
    public int reverse(int x) {
        int a, b;
        long c = 1;
        for(b = -1; x != 0;) {
            a = x % 10;
            if(b == -1)
            {
                c = a;
                b++;
            }
            else
            {
                c = c * 10 + a;
            }
            x= x / 10;
        }
        if(c <= Math.pow(2, 31) - 1 && c >= - Math.pow(2, 31)){
            return (int)c;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int reverse = new Reverse().reverse(1534236469);
        System.out.println(reverse);
    }
}
