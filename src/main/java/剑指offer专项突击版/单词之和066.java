package 剑指offer专项突击版;





/**
 * Title: 单词之和066
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-10
 */
public class 单词之和066 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("a"));
        System.out.println(mapSum.sum("aa"));
        mapSum.insert("aaa", 3);
        System.out.println(mapSum.sum("aaa"));
        System.out.println(mapSum.sum("bbb"));
        System.out.println(mapSum.sum("ccc"));
        mapSum.insert("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj", 111);
        System.out.println(mapSum.sum("aa"));
        System.out.println(mapSum.sum("a"));
        System.out.println(mapSum.sum("b"));
        System.out.println(mapSum.sum("c"));
        System.out.println(mapSum.sum("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj"));
        mapSum.insert("bb", 143);
        mapSum.insert("cc", 144);
        mapSum.insert("aew", 145);
        System.out.println(mapSum.sum("bb"));
        System.out.println(mapSum.sum("cc"));
        System.out.println(mapSum.sum("aew"));
    }
}
class MapSum {
    class Node {
        private Node[] next;
        private int val;
        private boolean isEnd;
        private int fullVal;
        public Node() {
            next = new Node[26];
            val = 0;
            fullVal = 0;
            isEnd = false;
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public MapSum() {

        root = new Node();
    }

    public void insert(String key, int val) {

        Node cur = root;
        int pre = isExist(key);
        for(char c : key.toCharArray()){
            if (null == cur.next[c - 'a']) {
                cur.next[c - 'a'] = new Node();
                cur.next[c - 'a'].val = val;
            } else {
                cur.next[c - 'a'].val -= pre;
                cur.next[c - 'a'].val += val;
            }
            cur = cur.next[c - 'a'];
        }

        cur.fullVal = val;
        cur.isEnd = true;
    }

    public int isExist(String s){
        Node cur = root;
        for(char c : s.toCharArray()){
            if (null == cur.next[c - 'a']) {
                return 0;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.isEnd ? cur.fullVal : 0;
    }

    public int sum(String prefix) {
        Node cur = root;
        for(char c : prefix.toCharArray()){

            if (null == cur.next[c - 'a']) {
                return 0;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.val;
    }


}
