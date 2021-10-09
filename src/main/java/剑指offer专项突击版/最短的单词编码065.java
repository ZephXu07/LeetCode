package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 最短的单词编码065
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-09
 */
public class 最短的单词编码065 {
//    public int minimumLengthEncoding(String[] words) {
//        /*
//            每个字符串长度最长为 7
//            一个字符串 7 个后缀
//         */
//        Set<String> set = new HashSet<>(Arrays.asList(words));
//        for (String w : words) {
//            for (int i = 1; i < w.length(); i++) {
//                /*
//                    如果某个字符串的后缀是一个完整的字符串，则这个字符串可以排除
//                 */
//                set.remove(w.substring(i));
//            }
//        }
//        int res = 0;
//        for (String s : set) {
//            res += s.length() + 1;
//            /*
//                不能省略的字符串长度与 #
//             */
//        }
//        return res;
//    }

    public int minimumLengthEncoding(String[] words) {
        /*
            反转之后利用前缀树
            前缀树每个节点在记录其有多少个子节点，0 个子节点为叶子节点
            前缀树的节点为叶子节点时，说明此路径的字符串是不能包含在其他字符串的后缀里面
            需要添加到编码里面，所以需要字符串长度 + # 的长度
         */
        Node root = new Node();
        int len = words.length;
        Map<Node, Integer> map = new HashMap<>(len);
        /*
            字符串的终点的节点与字符串所在的数组的下标
         */
        for (int i = 0; i < len; i++) {
            String w = words[i];
            Node cur = root;
            for (int j = w.length() - 1; j >= 0; j--) {
                cur = cur.get(w.charAt(j));
            }
            map.put(cur, i);
        }

        int res = 0;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            if (entry.getKey().count == 0) {
                res += words[entry.getValue()].length() + 1;
            }
        }
        return res;

    }

    class Node {
        private Node[] next;
        private int count;

        public Node() {
            next = new Node[26];
            count = 0;
        }

        public Node get (char c) {
            if (null == next[c - 'a']) {
                next[c - 'a'] = new Node();
                count++;
            }
            return next[c - 'a'];
        }
    }

    public static void main(String[] args) {
        最短的单词编码065 res = new 最短的单词编码065();
        System.out.println(res.minimumLengthEncoding(new String[]{"time", "me", "abe", "el", "bell"}));
    }
}
