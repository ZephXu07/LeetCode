package 剑指offer专项突击版;

/**
 * Title: 二进制加法002
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 二进制加法002 {
    public String addBinary(String a, String b) {
        int inx1 = a.length() - 1;
        int inx2 = b.length() - 1;
        int c = 0;
        int m;
        int n;
        int sum;
        StringBuilder res = new StringBuilder();
        while (inx1 >= 0 || inx2 >= 0) {
            m = inx1 >= 0 ? a.charAt(inx1--) - '0' : 0;
            n = inx2 >= 0 ? b.charAt(inx2--) - '0' : 0;
            sum = m + n + c;
            c = sum / 2;
            res.append(sum % 2);
        }
        if (c == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
