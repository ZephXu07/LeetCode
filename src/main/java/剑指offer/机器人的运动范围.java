package 剑指offer;

/**
 * Title: 机器人的运动范围
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return backtrack(visited, m, n, k, 0, 0);
    }

    private int backtrack(boolean[][] visited, int m, int n, int k, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }
        if (visited[x][y]) {
            return 0;
        }
        if (isLessThanK(x, y, k)) {
            return 0;
        }

        visited[x][y] = true;
        int res = 1;
        res += backtrack(visited, m, n, k, x + 1, y) +
                    backtrack(visited, m, n, k, x, y + 1);
        return res;
    }

    private boolean isLessThanK(int x, int y, int k) {
        int sum = 0;
        int tmp = x;
        sum = x % 10;
        while ((tmp /= 10 ) != 0) {
            sum += tmp % 10;
        }
        tmp = y;
        sum += y % 10;
        while ((tmp /= 10 ) != 0) {
            sum += tmp % 10;
        }
        return sum > k;
    }

    public static void main(String[] args) {
        机器人的运动范围 res = new 机器人的运动范围();
        System.out.println(res.movingCount(3, 2, 17));
    }
}
