package codetop;

import java.util.*;

/**
 * Title: 单词接龙
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-25
 */
public class 单词接龙 {
    private Set<String> dict;
    private Set<String> visited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        visited = new HashSet<>();
        Set<String> s1 = new HashSet<>();
        s1.add(beginWord);
        Set<String> s2 = new HashSet<>();
        s2.add(endWord);

        int step = 1;

        while (!s1.isEmpty() && !s2.isEmpty()) {
            Set<String> tmp = new HashSet<>();

            for (String s : s1) {
                if (visited.contains(s)) {
                    continue;
                }
                if (s2.contains(s)) {
                    return step;
                }
                visited.add(s);

                List<String> next = getAllNext(s);
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

        return 0;

    }

    private List<String> getAllNext (String cur) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < cur.length(); i++) {
            char c = cur.charAt(i);
            for (int j = 0; j < 26; j++) {
                char c1 = (char) ('a' + j);
                if (c == c1) {
                    continue;
                }
                String next = cur.substring(0, i) + c1 + cur.substring(i + 1);
                if (dict.contains(next) || visited.contains(next)) {
                    res.add(next);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        单词接龙 res = new 单词接龙();
        String beginWord = "hit", endWord = "cog";
        String[] strings = {"hot","dot","dog","lot","log"};
        List<String> wordList = new LinkedList<>(Arrays.asList(strings));
        System.out.println(res.ladderLength(beginWord, endWord, wordList));


    }
}
