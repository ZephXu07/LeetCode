package 剑指offer专项突击版;

import java.util.Arrays;
import java.util.List;

/**
 * Title: 替换单词063
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-09
 */
public class 替换单词063 {
    class Node {
        private Node[] next;
        private String word;

        public Node() {
            next = new Node[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String d : dictionary) {
            int len = d.length();
            Node cur = root;
            for (int i = 0; i < len; i++) {
                char c = d.charAt(i);
                Node next = cur.next[c - 'a'];
                if (null == next) {
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
            }
            cur.word = d;
        }

        StringBuilder res = new StringBuilder();
        String[] line = sentence.split(" ");
        for (String w : line) {
            Node cur = root;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (null == cur.next[c - 'a'] || null != cur.word) {
                    break;
                }
                cur = cur.next[c - 'a'];
            }
            res.append(cur.word != null ? cur.word : w).append(' ');
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {
        替换单词063 res = new 替换单词063();
        System.out.println(res.replaceWords(Arrays.asList("cat", "bat", "rat"),
                "the cattle was rattled by the battery"));
    }
}
