package codetop;

/**
 * Title: 矩形重叠
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 矩形重叠 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] ||
                rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }
        return !(rec1[0] >= rec2[2] ||
                rec2[0] >= rec1[2] ||
                rec1[1] >= rec2[3] ||
                rec2[1] >= rec1[3]);
        /*
            不相交情况
            1. 1左边的边大于等于2右边的边
            2. 2左边的边大于等于1右边的边
            2. 1下边的边大于等于2上边的边
            4. 2下边的边大于等于1上边的边

            取反则是题目要求
         */

    }
}
