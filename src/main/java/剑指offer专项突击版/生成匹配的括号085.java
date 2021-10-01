package 剑指offer专项突击版;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 生成匹配的括号085
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 生成匹配的括号085 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(n, n, builder, res);
        return res;
    }

    private void backtrack (int left, int right, StringBuilder builder, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }

        if (left < 0 || right < 0) {
            return;
        }

        if (left > 0) {
            backtrack(left - 1, right, builder.append('('), res);
            builder.deleteCharAt(builder.length() - 1);
            if (left < right) {
                backtrack(left, right - 1, builder.append(')'), res);
                builder.deleteCharAt(builder.length() - 1);
            }
        } else {
            backtrack(left, right - 1, builder.append(')'), res);
            builder.deleteCharAt(builder.length() - 1);
        }


    }
}
