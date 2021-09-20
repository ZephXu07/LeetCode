package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 较大分组的位置
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-05
 */
public class 较大分组的位置 {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (null == s || s.length() < 2) {
            return new LinkedList<>();
        }
        int len = s.length();
        List<List<Integer>> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        int start = 0;
        boolean flag = false;
        for (int i = 1; i < len; i++) {
            if (chars[i] != chars[start]) {
                if (i - start >= 3) {
                    List<Integer> group = new LinkedList<>();
                    group.add(start);
                    group.add(i - 1);
                    res.add(group);
                }
                flag = false;
                start = i;
            } else {
                flag = true;
            }
        }
        if (flag && len - start >= 3) {
            List<Integer> group = new LinkedList<>();
            group.add(start);
            group.add(len - 1);
            res.add(group);
        }
        return res;
    }


    public static void main(String[] args) {
        较大分组的位置 res = new 较大分组的位置();
        String s =  "abcdddeeeeaabbbcd";
        for (List<Integer> l :res.largeGroupPositions(s)) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
