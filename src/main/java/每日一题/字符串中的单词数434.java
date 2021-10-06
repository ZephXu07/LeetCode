package 每日一题;

/**
 * Title: 字符串中的单词数434
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-07
 */
public class 字符串中的单词数434 {
    public int countSegments(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                res++;
            }
        }

        return res;
    }
}
