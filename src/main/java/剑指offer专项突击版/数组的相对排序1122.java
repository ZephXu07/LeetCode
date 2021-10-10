package 剑指offer专项突击版;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title: 数组的相对排序1122
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-10
 */
public class 数组的相对排序1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int inx = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                int count = map.get(arr2[i]);
                while (count > 0) {
                    arr1[inx] = arr2[i];
                    inx++;
                    count--;
                }
                map.remove(arr2[i]);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet() ) {
            for (int i = 0; i < e.getValue(); i++) {
                arr1[inx] = e.getKey();
                inx++;
            }
        }
        return arr1;
    }
}
