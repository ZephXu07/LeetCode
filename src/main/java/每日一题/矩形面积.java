package 每日一题;

/**
 * Title: 矩形面积
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-30
 */
public class 矩形面积 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        int area1 = (ay2 - ay1) * (ax2 - ax1);
        int area2 = (by2 - by1) * (bx2 - bx1);
        /*
            各自面积
         */

        int len1 = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int len2 = Math.min(ay2, by2) - Math.max(ay1, by1);
        /*
            可能的交集的长度与宽度
         */

        return area1 + area2 - Math.max(0, len1) * Math.max(0, len2);
        /*
            如果没交集的话
            边长有一边为负数
         */
    }
}
