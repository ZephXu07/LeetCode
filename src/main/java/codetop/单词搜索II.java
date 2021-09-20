package codetop;


import java.util.*;

/**
 * Title: 单词搜索II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-16
 */
public class 单词搜索II {
//    private List<String> res;
//    private Set<String> memo;
//    private char[][] board;
//    private int row;
//    private int col;
//    private static final int[] DIR = {-1,0,1,0,-1};
//    public List<String> findWords(char[][] board, String[] words) {
//        if (null == board || board.length == 0) {
//            return new LinkedList<>();
//        }
//        memo = new HashSet<>();
//        Set<Character> set = new HashSet<>();
//        for (String w : words) {
//            set.add(w.charAt(0));
//            memo.add(w);
//        }
//        if (board.length == 1 && board[0].length == 1) {
//            List<String> ans = new LinkedList<>();
//            String tmp = new String(board[0]);
//            if (memo.contains(tmp)) {
//                ans.add(tmp);
//            }
//            return ans;
//        }
//
//
//        this.board = board;
//        row = board.length;
//        col = board[0].length;
//        res = new LinkedList<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (set.contains(board[i][j])) {
//                    StringBuilder path = new StringBuilder();
//                    boolean[][] visited = new boolean[row][col];
//                    path.append(board[i][j]);
//                    visited[i][j] = true;
//                    dfs(path, i, j, visited);
//                }
//            }
//        }
//        return res;
//    }
//
//    private void dfs (StringBuilder path, int x, int y, boolean[][] visited) {
//        if (path.length() > 10) {
//            return;
//        }
//        String tmp = path.toString();
//        if (memo.contains(tmp)) {
//            memo.remove(tmp);
//            res.add(tmp);
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + DIR[i];
//            int ny = y + DIR[i + 1];
//
//            if (!isValid(nx, ny) || visited[nx][ny]) {
//                continue;
//            }
//            visited[nx][ny] = true;
//            path.append(board[nx][ny]);
//            dfs(path, nx, ny, visited);
//            path.deleteCharAt(path.length() - 1);
//            visited[nx][ny] = false;
//        }
//
//    }
//
//    private boolean isValid (int x, int y) {
//        return x >= 0 && x < row && y >= 0 && y < col;
//    }

    private Set<String> res;
    private char[][] board;
    private int row;
    private int col;
    private static final int[] DIR = {-1,0,1,0,-1};

    public List<String> findWords(char[][] board, String[] words) {
        if (null == board || board.length == 0) {
            return new LinkedList<>();
        }
        res = new HashSet<>();

        Trie trie = build(words);

        StringBuilder path = new StringBuilder();
        this.board = board;
        row = board.length;
        col = board[0].length;
        res = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(path, i, j, trie);
            }
        }
        return new LinkedList<>(res);


    }

    private void dfs (StringBuilder path, int x, int y, Trie trie) {
        if (!isValid(x, y) || board[x][y] == '#'
                || null == trie.tries[board[x][y] - 'a']) {
            return;
        }

        path.append(board[x][y]);
        if (trie.tries[board[x][y] - 'a'].over) {
            res.add(path.toString());
        }
        char c = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int nx = x + DIR[i];
            int ny = y + DIR[i + 1];

            dfs(path, nx, ny, trie.tries[c - 'a']);

        }
        board[x][y] = c;
        path.deleteCharAt(path.length() - 1);
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    private Trie build(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Trie cur = root;
            for (char c : chars) {
                if (null == cur.tries[c - 'a']) {
                    cur.tries[c - 'a'] = new Trie();
                }
                cur = cur.tries[c - 'a'];
            }
            cur.over = true;
        }
        return root;
    }

    class Trie {
        Trie[] tries;
        boolean over;
        public Trie () {
            tries = new Trie[26];
        }
    }


    public static void main(String[] args) {
        单词搜索II res = new 单词搜索II();
        char[][] board = {{'a','b'}};
        String[] words = {"ab"};
        res.findWords(board,words).forEach(System.out::println);
    }
}
