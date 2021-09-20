package 每日一题;

import java.util.*;

/**
 * Title: 根据字符出现频率排序
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-03
 */
public class 根据字符出现频率排序 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(128);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, (a1, a2)->map.get(a2) - map.get(a1));
        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String frequencySort1(String s) {
        if (null == s || s.length() <= 2) {
            return s;
        }
        // 统计字符词频，建立词频表：O(n)
        char[] str = s.toCharArray();
        int[] count = new int[256];
        // char to count：字符词频表

        // 统计词频最大值：O(256)
        int maxCount = 0;
        for (char c : str) {
            count[c]++;
            maxCount = Math.max(maxCount, count[c]);
        }



        // 由词频表（count）构建桶排序表（array）：O(256)
        ArrayList[] array = new ArrayList[maxCount+1];
        // array[freq]：词频为count的字符集
        for (char c = 0; c < 256; c++) {
            int freq = count[c];
            if (array[freq] == null) {
                array[freq] = new ArrayList<Character>();
            }
            array[freq].add(c);
        }
        // 由桶排序表（array），生成结果字符串：O(n + 256)
        StringBuilder sb = new StringBuilder();
        for (int i = maxCount; i >= 0; i--) {
            if (array[i] != null) {
                for (int j = 0; j < array[i].size(); j++) {
                    char c = (Character) array[i].get(j);
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }
            }
            // 收集全了，提前终止循环：
            if (sb.length() == s.length()) {
                break;
            }
        }

        return sb.toString();
    }



}
