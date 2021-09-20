package 每日一题;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 二进制手表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-21
 */
public class 二进制手表 {
    private List<String> res;
    private static final int[] H = {1, 2, 4, 8};
    private static final int[] M = {1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int turnedOn) {
        res = new LinkedList<>();
        if (turnedOn > 8) {
            return res;
        }
        LinkedList<Integer> h = new LinkedList<>();
        LinkedList<Integer> m = new LinkedList<>();
        backtrack(turnedOn, 0, h, m);
        return res;
    }

    private void backtrack (int turnedOn, int inx, LinkedList<Integer> h, LinkedList<Integer> m) {
        if (inx > 10) {
            return;
        }
        if (turnedOn == 0) {
            int hour = getH(h);
            if (hour > 11) {
                return;
            }
            int minute = getM(m);
            if (minute > 59) {
                return;
            }
            res.add(getTime(hour, minute));
            return;
        }
        if (inx < 4) {
            backtrack(turnedOn, inx + 1, h, m);
            h.add(inx);
            backtrack(turnedOn - 1, inx + 1, h, m);
            h.removeLast();
        } else {
            backtrack(turnedOn, inx + 1, h, m);
            m.add(inx - 4);
            backtrack(turnedOn - 1, inx + 1, h, m);
            m.removeLast();
        }
    }

    private int getH (LinkedList<Integer> h) {
        int sum = 0;
        for (int i : h) {
            sum += H[i];
        }
        return sum;
    }

    private int getM (LinkedList<Integer> m) {
        int sum = 0;
        for (int i : m) {
            sum += M[i];
        }
        return sum;
    }

    private String getTime (int h, int m) {
        StringBuilder time = new StringBuilder();
        if (m < 10) {
            time.append(h).append(":0").append(m);
        } else {
            time.append(h).append(":").append(m);
        }
        return time.toString();
    }

    public static void main(String[] args) {
        二进制手表 match = new 二进制手表();
        int turnedOn = 9;
        List<String> list = match.readBinaryWatch(turnedOn);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("--------------");
//        turnedOn = 0;
//        list = match.readBinaryWatch(turnedOn);
//        for (String s : list) {
//            System.out.println(s);
//        }
    }
}
