package labuladong;

import java.util.Arrays;

/**
 * Title: labuladong.Rotate
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-12
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int oldI = 0;
        int oldJ = 0;
        int newI = 0;
        int newJ = 0;
        int tmp = 0;
        int value = 0;
        int i = 0;
        int j = 0;
        int total = matrix.length * matrix.length / 4;
        System.out.println(total);
        int sum = 0;

        do {
            oldI = i;
            oldJ = j;
            System.out.println(oldI + "\t" +  oldJ);
            value = matrix[i][j];
            for (int count = 0; count < 5; count++) {
                newI = oldJ;
                newJ = matrix.length - oldI - 1;
                tmp = matrix[newI][newJ];
                matrix[newI][newJ] = value;
                value = tmp;
                oldI = newI;
                oldJ = newJ;
            }
            sum ++;
            if (j >= total - 1) {
                i ++;
                j = 1;
            } else {
                j++;
            }
        } while (sum < total);

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
//                { 5, 1, 9,11},
//                { 2, 4, 8,10},
//                {13, 3, 6, 7},
//                {15,14,12,16}};
//            {1,2,3,4,5},
//            {6,7,8,9,10},
//            {11,12,13,14,15},
//            {16,17,18,19,20},
//            {21,22,23,24,25}};
        System.out.println(Arrays.deepToString(matrix));
        new Rotate().rotate(matrix);
    }
}
