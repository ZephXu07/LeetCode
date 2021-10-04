package week261;

/**
 * Title: 转换字符串的最少操作次数5890
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-03
 */
public class 转换字符串的最少操作次数5890 {
    public int minimumMoves(String s) {
        int len = s.length();
        int inx = 0;
        int res = 0;
        while (inx < len) {
            if (s.charAt(inx) == 'X') {
                inx += 3;
                res++;
            } else {
                inx++;
            }
        }
        return res;
    }
}
