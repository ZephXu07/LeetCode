package 每日一题;

/**
 * Title: 缀点成线
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-20
 */
public class 缀点成线 {
    public boolean checkStraightLine(int[][] coordinates) {
        /*斜率会涉及到除数为00的问题，即垂直于x轴的直线需要单独判断。而且在计算浮点除法运算时还会涉及到精度问题
        我们可以把点集中除了外的点 都看成以为起点、终点的向量，记为选择作为基准。
        如果其他向量都与共线，那么点集内所有的点共线。这里需要用到线性代数的基础知识：
        如果二维向量 α 与 β 共线，那么它们线性相关，且有：|α , β | = 0
        即它们拼成的二阶矩阵的行列式为 0。
         */
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
