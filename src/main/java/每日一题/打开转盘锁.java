package 每日一题;

import java.util.*;

/**
 * Title: 打开转盘锁
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-25
 */
public class 打开转盘锁 {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>(deadends.length);
        for (String d : deadends) {
            if ("0000".equals(d)) {
                return -1;
            }
            dead.add(d);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                List<String> next = getAllNum(tmp);
                for (String n : next) {
                    if (dead.contains(n) || visited.contains(n)) {
                        continue;
                    }
                    if (target.equals(n)) {
                        return step;
                    }
                    queue.add(n);
                    visited.add(n);
                }
            }
        }
        return -1;
    }

    public int openLock1(String[] deadends, String target) {

        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>(deadends.length);
        for (String d : deadends) {
            if ("0000".equals(d)) {
                return -1;
            }
            dead.add(d);
        }
        Set<String> visited = new HashSet<>(deadends.length);
        Set<String> s1 = new HashSet<>();
        s1.add("0000");
        Set<String> s2 = new HashSet<>();
        s2.add(target);
        int step = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            Set<String> tmp = new HashSet<>();

            for (String s : s1) {
                if (dead.contains(s) || visited.contains(s)) {
                    continue;
                }
                if (s2.contains(s)) {
                    return step;
                }
                visited.add(s);
                List<String> next = getAllNum(s);
                for (String n : next) {
                    if (visited.contains(n)) {
                        continue;
                    }
                    tmp.add(n);
                }
            }

            step++;
            if (s2.size() <= tmp.size()) {
                s1 = s2;
                s2 = tmp;
            } else {
                s1 = tmp;
            }
        }
        return -1;
    }

    private List<String> getAllNum (String cur) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            res.add(nextNum(cur, i));
            res.add(lastNum(cur, i));
        }
        return res;
    }

    private String nextNum (String cur, int inx) {
        char[] chars = cur.toCharArray();
        if (chars[inx] == '9') {
            chars[inx] = '0';
        } else {
            chars[inx] ++;
        }
        return new String(chars);
    }

    private String lastNum (String cur, int inx) {
        char[] chars = cur.toCharArray();
        if (chars[inx] == '0') {
            chars[inx] = '9';
        } else {
            chars[inx] --;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        打开转盘锁 res = new 打开转盘锁();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(res.openLock(deadends, target));
        System.out.println(res.openLock1(deadends, target));
    }
}
