package 每日一题;

import lombok.val;

import java.util.*;

/**
 * Title: 将数据流变为多个不相交区间352
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-09
 */
public class 将数据流变为多个不相交区间352 {
    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        s.addNum(6);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(6);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(0);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(4);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(8);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(7);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(6);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(4);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(7);
        System.out.println(Arrays.deepToString(s.getIntervals()));
        s.addNum(5);
        System.out.println(Arrays.deepToString(s.getIntervals()));
    }
}
class SummaryRanges {
    private TreeMap<Integer, Integer> tree;
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> left = tree.floorEntry(val);
        Map.Entry<Integer, Integer> right = tree.ceilingEntry(val);

        if (null == left && null == right) {
            /*
                初始化
             */
            tree.put(val, val);
        } else if (null == left) {
            if (right.getKey() - 1 == val) {
                /*
                    null  |_|___|
                 */
                tree.remove(right.getKey());
                tree.put(val, right.getValue());
            } else if (right.getKey() - 1 > val){
                /*
                    null |  |___|
                 */
                tree.put(val, val);
            }
        } else if (null == right) {
            if (left.getValue() + 1 == val) {
                /*
                    |___|_|  null
                 */
                tree.put(left.getKey(), val);
            } else if (left.getValue() + 1 < val){
                /*
                    |___|   |  null
                 */
                tree.put(val, val);
            }
        } else if (left.getValue() == val && right.getKey() == val) {
            /*
                |____|_____|
             */
            tree.remove(left.getKey());
            tree.remove(right.getKey());
            tree.put(left.getKey(), right.getValue());
        } else if (left.getValue() == val || right.getKey() == val ||
                (left.getKey() <= val && left.getValue() >= val)) {
            /*
                |___|           |____|
                |_____|____|
             */
            return;
        } else if (left.getValue() + 1 == val && right.getKey() - 1 == val) {
            /*
                |____|_|_____|
             */
            tree.remove(left.getKey());
            tree.remove(right.getKey());
            tree.put(left.getKey(), right.getValue());
        } else if (left.getValue() + 1 == val) {
            /*
                |____|_|   |____|
             */
            tree.put(left.getKey(), val);
        } else if (right.getKey() - 1 == val) {
            /*
                |____|   |_|_____|
             */
            tree.remove(right.getKey());
            tree.put(val, right.getValue());
        } else {
            /*
                |____|  |   |_____|
             */
            tree.put(val, val);
        }

    }

    public int[][] getIntervals() {
        int[][] res = new int[tree.size()][2];
        int inx = 0;
        for (Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            res[inx][0] = entry.getKey();
            res[inx][1] = entry.getValue();
            inx++;
        }
        return res;
    }
}
