package codetop;

import 每日一题.杨辉三角二;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 杨辉三角
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> level = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    level.add(1);
                } else {
                    List<Integer> pre = res.get(i - 2);
                    level.add(pre.get(j - 2) + pre.get(j - 1));
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        杨辉三角 res = new 杨辉三角();
        final List<List<Integer>> generate = res.generate(5);
        for (List<Integer> l : generate) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
