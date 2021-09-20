package twotwosix周赛;

/**
 * Title: 盒子中小球的最大数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-31
 */
public class 盒子中小球的最大数量 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int cur = lowLimit;
        while (cur <= highLimit) {
            int inx = getInx(cur);
            count[inx]++;
            cur++;
        }
        int res = 0;
        for (int i = 1; i <= 45; i++) {
            res = Math.max(res, count[i]);
        }
        return res;
    }


    private int getInx(int value) {
        int inx = 0;
        while (value != 0) {
            inx += value % 10;
            value /= 10;
        }
        return inx;
    }

    public static void main(String[] args) {
        盒子中小球的最大数量 res = new 盒子中小球的最大数量();
        int low = 19;
        int high = 28;
        System.out.println(res.countBalls(low, high));

    }
}
