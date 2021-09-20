package 每日一题;

/**
 * Title: 学生出勤记录I
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-17
 */
public class 学生出勤记录I {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (++aCount == 2) {
                    return false;
                }
                lCount = 0;
            } else if (c == 'L') {
                if (++lCount == 3) {
                    return false;
                }
            } else {
                lCount = 0;
            }
        }
        return true;
    }
}
