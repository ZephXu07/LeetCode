package 二三九周赛;

/**
 * Title: 将字符串拆分为递减的连续值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-02
 */
public class 将字符串拆分为递减的连续值 {
    public boolean splitString(String s) {
        int len = s.length();
        if (len == 1) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            int a = Integer.parseInt(s.substring(0, i));
            int b = helper(s.substring(i), a);
            if (a - b == 1) {
                return true;
            } else {

            }
        }

        return false;
    }

    private int helper(String s, int max) {
        int len = s.length();
        int tmp = Integer.parseInt(s);
        if (max - 1 == tmp) {
            return tmp;
        }

        for (int i = 1; i < len; i++) {
            int a = Integer.parseInt(s.substring(0, i));
            int b = helper(s.substring(i), a);
            if (a - b == 1) {

            }
        }
        return 0;
    }

}
