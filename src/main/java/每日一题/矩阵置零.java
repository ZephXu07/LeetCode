package 每日一题;

/**
 * Title: 矩阵置零
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        boolean[][] visited = new boolean[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (matrix[i][j] == 0 && !visited[i][j]) {
//                    for (int k = 0; k < col; k++) {
//                        if (matrix[i][k] == 0) {
//                            continue;
//                        }
//                        matrix[i][k] = 0;
//                        visited[i][k] = true;
//                    }
//                    for (int k = 0; k < row; k++) {
//                        if (matrix[k][j] == 0) {
//                            continue;
//                        }
//                        matrix[k][j] = 0;
//                        visited[k][j] = true;
//                    }
//                }
//            }
//        }

//        int m = matrix.length;
//        int n = matrix[0].length;
//        boolean[] row = new boolean[m];
//        boolean[] col = new boolean[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0 ) {
//                    row[i] = true;
//                    col[j] = true;
//                }
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (row[i] || col[j]) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }


//        int m = matrix.length, n = matrix[0].length;
//        boolean flagCol0 = false, flagRow0 = false;
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] == 0) {
//                flagCol0 = true;
//                break;
//            }
//        }
//        for (int j = 0; j < n; j++) {
//            if (matrix[0][j] == 0) {
//                flagRow0 = true;
//                break;
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[i][0] = matrix[0][j] = 0;
//                }
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        if (flagCol0) {
//            for (int i = 0; i < m; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//        if (flagRow0) {
//            for (int j = 0; j < n; j++) {
//                matrix[0][j] = 0;
//            }
//        }
        //用第一行和第一列来作为第二种方法的辅助数组，当某一列或某一行出现0，此列或此行全为0 ，所以此列或此行第一个先标记为0，下面再循环改变其他
        //前提是先遍历第一行和第一列，避免原本就有0而忘记修改，用两个变量表示，最后再根据两个变量的值决定是否修改

        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
        //其实不用用两个变量，一个就需要了，当第一行有0时，（0，0）变成0，此时无法知道原来是何值，
        // 因为遍历的时候跳过了第一列，所以使用一个变量来存储第一列是否有0
    }


    public static void main(String[] args) {
        矩阵置零 res = new 矩阵置零();
        int[][] matrix = {{1,0},{1,0}};
        res.setZeroes(matrix);
        for (int[] m : matrix) {
            for (int i : m) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
