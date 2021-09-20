package labuladong;

import java.util.*;

/**
 * Title: labuladong.SlidingPuzzle
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-16
 */
public class SlidingPuzzle {
    public static void main(String[] args) {
        int[][] board = {{3, 4, 2}, {1, 5, 0}};
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int i = slidingPuzzle.slidingPuzzle(board);
        System.out.println(i);
    }

    public int slidingPuzzle(int[][] board) {
        int row = 2;
        int column = 3;
        StringBuilder start = new StringBuilder();
        String target = "123450";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                start.append(board[i][j]);
            }
        }
        List<int[]> neighbor = new ArrayList<>();
        neighbor.add(new int[]{1, 3});
        neighbor.add(new int[]{0, 4, 2});
        neighbor.add(new int[]{1, 5});
        neighbor.add(new int[]{0, 4});
        neighbor.add(new int[]{3, 1, 5});
        neighbor.add(new int[]{4, 2});
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int count = 0;
        int size;
        String curStr;
        String newStr;
        int index = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                curStr = queue.poll();
                if (target.equals(curStr)) {
                    return count;
                }
                index = 0;
                while('0' != curStr.charAt(index)) {
                    index ++;
                }
                for(int j : neighbor.get(index)) {
                    newStr = swap(j, index, curStr);
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        queue.offer(newStr);
                    }
                }
            }
            count ++;
        }
        return -1;
    }

    private String swap(int i, int j, String oldStr) {
        StringBuilder newStr = new StringBuilder(oldStr);
        newStr.setCharAt(i, oldStr.charAt(j));
        newStr.setCharAt(j, oldStr.charAt(i));
        return newStr.toString();
    }
}
