package codetop;

/**
 * Title: 对角线遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 对角线遍历 {
    public int[] findDiagonalOrder(int[][] mat) {
        /*
            总遍历数 m * n
            行数 m
            列数 n
            行和列的和 i 从 0 到 m + n - 2
            x 最大时为 i 与 m - 1 的比较，取小的
            y 最大时为 i 与 n - 1 的比较，取小的
            向右上角遍历时 x--，y++，满足条件为 x >= 0 且 y < n，否则则停止
            向左下角遍历时 x++，y--，满足条件为 x < m 且 y >= 0，否则则停止

            方向一次遍历改变一次
         */
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        boolean up = true;
        int x;
        int y;
        int inx = 0;
        for (int i = 0; i <= m + n - 2; i++) {
            if (up) {
                x = i >= m ? m - 1 : i;
                y = i - x;
                while (x >= 0 && y < n) {
                    res[inx++] = mat[x][y];
                    x--;
                    y++;
                }
                up = false;
            } else {
                y = i >= n ? n - 1 : i;
                x = i - y;
                while (y >= 0 && x < m) {
                    res[inx++] = mat[x][y];
                    x++;
                    y--;
                }
                up = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        对角线遍历 res = new 对角线遍历();
//        int[][] mat = {{ 1, 2, 3 },
//                         { 4, 5, 6 },
//                         { 7, 8, 9 }};
        int[][] mat = {{ 1, 2, 3 , 4},
                { 4, 5, 6 },
                { 7, 8, 9 }};
        final int[] diagonalOrder = res.findDiagonalOrder(mat);
        for (int i : diagonalOrder) {
            System.out.print(i + "\t");
        }
    }
}
