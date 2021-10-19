package 杂类;



/**
 * Title: 词典中最长的单词720
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-19
 */
public class 词典中最长的单词720 {
//    public String longestWord(String[] words) {
//        Arrays.sort(words, (w0, w1)-> {
//            if (w0.length() == w1.length()) {
//                return w0.compareTo(w1);
//            }
//            return w1.length() - w0.length();
//        });
//        Set<String> set = new HashSet<>(Arrays.asList(words));
//        for (String w : words) {
//            boolean flag = true;
//            for (int i = 1; i < w.length(); i++) {
//                if (!set.contains(w.substring(0, i))) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                return w;
//            }
//        }
//        return "";
//    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        int max = 0;
        String res = "";
        for(String word: words){
            if(trie.isBuild(word) && word.length() > max){
                //遍历后发现有更长的string满足条件，进行替换
                res = word;
                max = word.length();
            }else if(trie.isBuild(word) && word.length() == max){
                if (word.compareTo(res) < 0) {
                    res = word;
                }
            }
        }
        return res;

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

        public boolean isBuild(String string){
            //用来判断这个字符串是不是由其他节点依次加一个字符组成
            char[] chars = string.toCharArray();
            Node cur = root;
            for (char aChar : chars) {
                if (!cur.next[aChar - 'a'].isFinish) {
                    return false;
                }
                cur = cur.next[aChar - 'a'];
            }
            return true;
        }

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
