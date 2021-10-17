package test;

import java.util.*;

/**
 * Title: main
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-17
 */
public class main {
    public static void main (String[] avgs) {
        Scanner in = new Scanner (System.in);
        String s = in.nextLine();

        String[] data = s.split (" ");

        Map<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(data[i].length())) {
                map.get(data[i].length()).add(data[i]);
            } else {
                List<String> list = new LinkedList<>();
                list.add(data[i]);
                map.put(data[i].length(), list);
            }

        }

        StringBuilder res = new StringBuilder();
        for (Map.Entry<Integer, List<String>> e : map.entrySet()) {
            for (String d : e.getValue()) {
                if (res.length() == 0) {
                    res.append(d).append(" ");
                    res.setCharAt(0, (char) (res.charAt(0) - 'a' + 'A'));
                } else {
                    res.append(d).append(" ");
                }
            }
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println(res);

    }
}
