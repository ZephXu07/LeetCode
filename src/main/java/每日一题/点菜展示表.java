package 每日一题;

import java.util.*;

/**
 * Title: 点菜展示表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-11
 */
public class 点菜展示表 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, TreeMap<String, Integer>> table = new TreeMap<>();
        TreeSet<String> foods = new TreeSet<>();
        for (List<String> order : orders) {
            int t = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foods.add(food);
            if (table.containsKey(t)) {
                TreeMap<String, Integer> tmp = table.get(t);
                tmp.put(food, tmp.getOrDefault(food, 0) + 1);
            } else {
                TreeMap<String, Integer> tmp = new TreeMap<>();
                tmp.put(food, 1);
                table.put(t, tmp);
            }
        }
        List<List<String>> res = new LinkedList<>();
        List<String> title = new LinkedList<>();
        title.add("Table");
        title.addAll(foods);
        res.add(title);
        for (Map.Entry<Integer, TreeMap<String, Integer>> entry: table.entrySet()) {
            List<String> level = new LinkedList<>();
            level.add(String.valueOf(entry.getKey()));
            TreeMap<String, Integer> value = entry.getValue();
            for (int i = 1; i < res.get(0).size(); i++) {
                String food = res.get(0).get(i);
                if (value.containsKey(food)) {
                    level.add(String.valueOf(value.get(food)));
                } else {
                    level.add("0");
                }
            }
            res.add(level);
        }
        return res;
    }
}
