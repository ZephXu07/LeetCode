package 剑指offer专项突击版;


/**
 * Title: 神奇的字典064
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-09
 */
public class 神奇的字典064 {
}
class MagicDictionary {
    private Node root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String d : dictionary) {
            int len = d.length();
            Node curNode = root;
            for (int i = 0; i < len; i++) {
                char curChar = d.charAt(i);
                Node next = curNode.next[curChar - 'a'];
                if (null == next) {
                    curNode.next[curChar - 'a'] = new Node();
                }
                curNode = curNode.next[curChar - 'a'];
            }
            curNode.isFinish = true;
        }
    }

    public boolean search(String searchWord) {
        char[] word = searchWord.toCharArray();
        for (int i = 0; i < word.length; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == word[i]) {
                    continue;
                }
                char c = word[i];
                word[i] = j;
                if (searchWord(word)) {
                    return true;
                }
                word[i] = c;
            }
        }
        return false;
    }

    private boolean searchWord(char[] word) {
        Node cur = root;
        for (int i = 0; i < word.length; i++) {
            int inx = word[i] - 'a';
            if (null != cur.next[inx]) {
                cur = cur.next[inx];
                continue;
            }
            return false;
        }
        return cur.isFinish;
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
