package 每日一题;

/**
 * Title: 检测大写字母520
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-13
 */
public class 检测大写字母520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        int start;
        if (!isHigh(word.charAt(0))) {
            start = 2;
            if (isHigh(word.charAt(1))) {
                return false;
            }
        } else {
            if (isHigh(word.charAt(1))) {
                start = 1;
            } else {
                start = 3;
            }
        }

        for (int i = 2; i < word.length(); i++) {
            boolean flag = isHigh(word.charAt(i));
            if (start == 2 && flag) {
                return false;
            }

            if (start == 1 && !flag) {
                return false;
            }

            if (start == 3 && flag) {
                return false;
            }

        }
        return true;
    }

    private boolean isHigh (char c) {
        return c >= 'A' && c <= 'Z';
    }
}
