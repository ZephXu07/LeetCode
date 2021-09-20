package codetop;

/**
 * Title: 字符串压缩
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 字符串压缩 {
    public String compressString(String S) {
        int len = S.length();
        if (len <= 2) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        char pre = S.charAt(0);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (S.charAt(i) == pre) {
                count++;
            } else {
                res.append(pre).append(count);
                if (res.length() >= len) {
                    return S;
                }
                count = 1;
                pre = S.charAt(i);
            }
        }
        res.append(pre).append(count);
        if (res.length() >= len) {
            return S;
        }
        return res.toString();
    }


}
