package labuladong;

import java.util.*;

/**
 * Title: labuladong.DiffWaysToCompute
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-27
 */
public class DiffWaysToCompute {
    private Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ('+' == c || '-' == c || '*' == c) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+' :
                                res.add(l + r);
                                break;
                            case '-' :
                                res.add(l - r);
                                break;
                            case '*' :
                                res.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        memo.put(input, res);
        return res;
    }

    public static void main(String[] args) {
        String input = "2-1-1";
        DiffWaysToCompute ways = new DiffWaysToCompute();
        List<Integer> list = ways.diffWaysToCompute(input);
        System.out.println(Arrays.toString(list.toArray()));
    }






}
