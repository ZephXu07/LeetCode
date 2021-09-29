package codetop;

/**
 * Title: 外观数列38
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-29
 */
public class 外观数列38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder res = new StringBuilder();
        String pre = countAndSay(n - 1);
        int len = pre.length();
        int inx = 0;
        for (int i = 1; i <= len; i++) {
            if (i == len) {
                res.append(i - inx).append(pre.charAt(inx));
            } else if (pre.charAt(i) != pre.charAt(inx)) {
                res.append(i - inx).append(pre.charAt(inx));
                inx = i;
            }
        }
        return res.toString();
    }
}
