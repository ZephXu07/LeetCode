package 剑指offer专项突击版;

/**
 * Title: 实现前缀树062
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-09
 */
public class 实现前缀树062 {

}
class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        int len = word.length();
        Node cur = root;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            Node next = cur.next[c - 'a'];
            if (null == next) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isFinish = true;
    }


    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int inx = word.charAt(i) - 'a';
            if (null != cur.next[inx]) {
                cur = cur.next[inx];
                continue;
            }
            return false;
        }
        return cur.isFinish;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int inx = prefix.charAt(i) - 'a';
            if (null != cur.next[inx]) {
                cur = cur.next[inx];
                continue;
            }
            return false;
        }
        return true;
    }

    class Node {
        private Node[] next;
        private boolean isFinish;

        public Node() {
            next = new Node[26];
            isFinish = false;
        }
    }
}
