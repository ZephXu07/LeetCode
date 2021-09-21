package codetop;

/**
 * Title: 添加与搜索单词数据结构设计211
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-21
 */
public class 添加与搜索单词数据结构设计211 {
}
class WordDictionary {
    class Node {
        private Node[] next;
        private boolean isFinish;

        public Node() {
            next = new Node[26];
            isFinish = false;
        }
    }

    private Node root;


    public WordDictionary() {
        root = new Node();
    }


    public void addWord(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curChar = word.charAt(i);
            Node next = curNode.next[curChar - 'a'];
            if (null == next) {
                curNode.next[curChar - 'a'] = new Node();
            }
            curNode = curNode.next[curChar - 'a'];
        }
        curNode.isFinish = true;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, Node node, int inx) {
        if (inx == word.length()) {
            return node.isFinish;
        }
        char c = word.charAt(inx);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.next[i] != null && search(word, node.next[i], inx + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (null == node.next[c - 'a']) {
                return false;
            }
            return search(word, node.next[c - 'a'], inx + 1);
        }
    }
}
