package weekTwo62;

/**
 * Title: 将一维数组转变成二维数组5871
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-02
 */
public class 将一维数组转变成二维数组5871 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (len != m * n) {
            return new int[0][];
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < len; i++) {
            int x = i / n;
            int y = i % n;
            res[x][y] = original[i];
        }
        return res;
    }
}
