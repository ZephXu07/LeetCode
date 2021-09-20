package codetop;

import java.util.*;

/**
 * Title: 单词转换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 单词转换 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Set<String> set = new HashSet<>(wordList);
        List<String> res = new LinkedList<>();
        if (!set.contains(endWord)) {
            return res;
        }
        res.add(beginWord);
        char[] end = endWord.toCharArray();
        char[] begin = beginWord.toCharArray();
        Set<String> visited = new HashSet<>();
        if (dfs(begin, end, set,visited, res)) {
            return res;
        }
        return new LinkedList<>();


    }

    private boolean dfs (char[] begin, char[] end, Set<String> set,  Set<String> visited, List<String> res) {
        if (new String(begin).equals(new String(end))) {
            return true;
        }
        for (int i = 0; i < begin.length; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == begin[i]) {
                    continue;
                }
                char tmp = begin[i];
                begin[i] = j;
                String s = new String(begin);
                if (set.contains(s) && !visited.contains(s)) {
                    res.add(s);
                    visited.add(s);
                    if (dfs(begin, end, set, visited, res)) {
                        return true;
                    }
                    res.remove(res.size() - 1);
                }
                begin[i] = tmp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        单词转换 res = new 单词转换();
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        res.findLadders("hit", "cog", list).forEach(System.out::println);
    }
}
