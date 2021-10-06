package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 外星文字典114
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */
public class 外星文字典114 {
    public String alienOrder(String[] words) {
        /*
            前一个字符串与后一个字符串同下标形成有向边
            如果出现类似 "abc" > "ab" 特例则返回
            进行拓扑排序，如果不能全部排序，即所有出现的字符串的入度为 0 则错误
            否则正确返回
         */
        int len = words.length;

        int[] degree = new int[26];
        List<Integer>[] edges = new List[26];

        for (int i = 0; i < 26; i++) {
            degree[i] = -1;
            edges[i] = new LinkedList<>();
        }


        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                degree[w.charAt(i) - 'a'] = 0;
                edges[i] = new LinkedList<>();
            }
        }

        for (int i = 1; i < len; i++) {
            int min = Math.min(words[i - 1].length(), words[i].length());
            for (int j = 0; j < min; j++) {
                char c1 = words[i - 1].charAt(j);
                char c2 = words[i].charAt(j);
                if (c1 == c2) {
                    if (j == min - 1 && words[i - 1].length() > words[i].length()) {
                        return "";
                    }
                    continue;
                }
                edges[c1 - 'a'].add(c2 - 'a');
                degree[c2 - 'a']++;
                break;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder res = new StringBuilder();

        while (!queue.isEmpty()) {
            int i = queue.poll();
            res.append((char) ('a' + i));
            for (int j : edges[i]) {
                degree[j]--;
                if (degree[j] == 0) {
                    queue.offer(j);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (degree[i] > 0) {
                return "";
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        外星文字典114 res = new 外星文字典114();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(res.alienOrder(words));
    }
}
