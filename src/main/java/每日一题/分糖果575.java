package 每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: 分糖果575
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-01
 */
public class 分糖果575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int c : candyType) {
            set.add(c);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
