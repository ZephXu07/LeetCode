package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 蛇梯棋
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 蛇梯棋 {
    private int len;
    public int snakesAndLadders(int[][] board) {
        len = board.length;
        boolean[] visited = new boolean[len * len + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int step = 0;
        int target = len * len;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                if (visited[tmp]) {
                    continue;
                }
                visited[tmp] = true;
                if (tmp == target) {
                    return step;
                }
                for (int j = 1; j <= 6; j++) {
                    int next = tmp + j;
                    if (next > target) {
                        break;
                    }
                    int[] xy = getXAndY(next);
                    if (board[xy[0]][xy[1]] != -1) {
                        next = board[xy[0]][xy[1]];
                    }
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

    private int[] getXAndY (int num) {
        int x = (len - 1) - (num - 1) / len;
        int y;
        if ((len & 1) == 0) {
            y = (x & 1) == 1 ?
                    num - (((len - 1) - x) * len + 1) :
                    len - (num - ((len - 1) - x) * len);
        } else {
            y = (x & 1) == 1 ?
                    len - (num - ((len - 1) - x) * len) :
                    num - (((len - 1) - x) * len + 1);
        }
        return new int[]{x, y};
    }


    public static void main(String[] args) {
        蛇梯棋 res = new 蛇梯棋();
        int[][] board = {{-1,-1,19,10,-1},
                        {2,-1,-1,6,-1},
                        {-1,17,-1,19,-1},
                        {25,-1,20,-1,-1},
                        {-1,-1,-1,-1,15}
                        };
        System.out.println(res.snakesAndLadders(board));
    }
}
