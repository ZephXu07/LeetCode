package 每日一题;

import java.util.*;

/**
 * Title: 旅行终点站1436
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 旅行终点站1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> inDegree = new HashMap<>(paths.size() / 2);
        for (List<String> path : paths) {
            inDegree.put(path.get(0), inDegree.getOrDefault(path.get(0), 0) + 1);
            inDegree.put(path.get(1), inDegree.getOrDefault(path.get(1), 0));
        }
        for (Map.Entry<String, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                return e.getKey();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        旅行终点站1436 res = new 旅行终点站1436();
        List<List<String>> lists = new LinkedList<>();
        lists.add(Arrays.asList("pYyNGfBYbm","wxAscRuzOl"));
        lists.add(Arrays.asList("kzwEQHfwce","pYyNGfBYbm"));
//        lists.add(Arrays.asList("Lima","Sao Paulo"));
        System.out.println(res.destCity(lists));
    }
}
