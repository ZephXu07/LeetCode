package labuladong;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: labuladong.GenerateParenthesis
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-15
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> strings = g.generateParenthesis(3);
        for (String s:strings) {
            System.out.println(s);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        backtrack(n, n, res, track);
        return res;
    }

    private void backtrack(int left, int right, List<String> res, StringBuilder track) {
        if (left > right) {
            return;
        }
        if (left < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        track.append("(");
        backtrack(left - 1, right, res, track);
        track.deleteCharAt(track.length() - 1);

        track.append(")");
        backtrack(left, right - 1, res, track);
        track.deleteCharAt(track.length() - 1);
    }
}
