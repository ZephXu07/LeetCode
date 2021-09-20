package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 实现Trie前缀树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-14
 */
public class 实现Trie前缀树 {
}
class Trie {
    private Node[] nodes;

    /** Initialize your data structure here. */
    public Trie() {
        nodes = new Node[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node[] tmp = nodes;
        int i = 0;
        for (; i < word.length(); i++) {
            int inx = word.charAt(i) - 'a';
            if (null == tmp[inx]) {
                tmp[inx] = new Node();
            }

            tmp = tmp[inx].nodes;
        }
        tmp[word.charAt(i - 1) - 'a'].over = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node[] tmp = nodes;
        int i = 0;
        for (; i < word.length(); i++) {
            int inx = word.charAt(i) - 'a';
            if (null != tmp[inx]) {
                tmp = tmp[inx].nodes;
                continue;
            }
            return false;
        }
        return tmp[word.charAt(i - 1) - 'a'].over;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node[] tmp = nodes;
        for (int i = 0; i < prefix.length(); i++) {
            int inx = prefix.charAt(i) - 'a';
            if (null != tmp[inx]) {
                tmp = tmp[inx].nodes;
                continue;
            }
            return false;
        }
        return true;
    }


}
class Node {
    Node[] nodes;
    boolean over;
    public Node () {
        nodes = new Node[26];
        over = false;
    }
}
