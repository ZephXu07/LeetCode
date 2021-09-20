package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 电话号码的字母组合
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-24
 */
public class 电话号码的字母组合 {
    private List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }
        StringBuilder builder = new StringBuilder();
        backtrack(builder, 0, digits);
        return res;
    }

    private void backtrack (StringBuilder builder, int inx, String digits) {
        if (inx == digits.length()) {
            res.add(builder.toString());
            return;
        }
        int num = digits.charAt(inx) - '0';

        int count;
        int cur;
        if (num == 7 || num == 9) {
            count = 4;
            cur = num == 7 ? 15 : 22;
        } else {
            count = 3;
            cur = num == 8 ? 19 : (num - 2) * 3;
        }

        for (int i = 0; i < count; i++) {
            char c = (char) ('a' + cur + i);
            builder.append(c);
            backtrack(builder, inx + 1, digits);
            builder.deleteCharAt(inx);
        }
    }

    public static void main(String[] args) {
        电话号码的字母组合 phone = new 电话号码的字母组合();
        String digits = "7";
        List<String> list = phone.letterCombinations(digits);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
