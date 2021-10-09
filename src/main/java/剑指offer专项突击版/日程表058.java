package 剑指offer专项突击版;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title: 日程表058
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-09
 */
public class 日程表058 {
    public static void main(String[] args) {
        MyCalendar c = new MyCalendar();
        System.out.println(c.book(47, 50) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(33, 41) + Arrays.deepToString(c.getIntervals()));

        System.out.println(c.book(39,45) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(33,42) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(25,32) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(26,35) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(19,25) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(3,8) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(8,13) + Arrays.deepToString(c.getIntervals()));
        System.out.println(c.book(18,27) + Arrays.deepToString(c.getIntervals()));
    }
}
class MyCalendar {

    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pre = calendar.floorEntry(start);
        Map.Entry<Integer, Integer> tail = calendar.ceilingEntry(start);
        if (null == pre && null == tail) {
            calendar.put(start, end);
            return true;
        } else if (null == pre) {
            if (tail.getKey() > end) {
                calendar.put(start, end);
                return true;
            } else if (tail.getKey() == end) {
                calendar.remove(tail.getKey());
                calendar.put(start, tail.getValue());
                return true;
            } else {
                return false;
            }
        } else if (null == tail) {
            if (pre.getValue() < start) {
                calendar.put(start, end);
                return true;
            } else if (pre.getValue() == start) {
                calendar.put(pre.getKey(), end);
                return true;
            } else {
                return false;
            }
        } else {
             if (pre.getValue() == start && tail.getKey() == end) {
                calendar.remove(end);
                calendar.put(pre.getKey(), tail.getValue());
                return true;
            } else if (pre.getValue() == start && tail.getKey() > end) {
                calendar.put(pre.getKey(), end);
                return true;
            } else if (pre.getValue() < start && tail.getKey() == end) {
                calendar.remove(tail.getKey());
                calendar.put(start, tail.getValue());
                return true;
            } else if (pre.getValue() < start && tail.getKey() > end) {
                calendar.put(start, end);
                return true;
            } else if (pre.getValue() > start || end > tail.getKey()) {
                return false;
            } else {
                return false;
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[calendar.size()][2];
        int inx = 0;
        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            res[inx][0] = entry.getKey();
            res[inx][1] = entry.getValue();
            inx++;
        }
        return res;
    }
}
