package 每日一题;

import java.util.Arrays;

/**
 * Title: 构造矩形492
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-23
 */
public class 构造矩形492 {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int min = area;
        for (int i = area; i >= Math.sqrt(area); i--) {
            if (area % i != 0) {
                continue;
            }
            int j = area / i;
            if (i - j < min) {
                min = i - j;
                res[0] = i;
                res[1] = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        构造矩形492 res = new 构造矩形492();
        System.out.println(Arrays.toString(res.constructRectangle(4)));
        System.out.println(Arrays.toString(res.constructRectangle(37)));
        System.out.println(Arrays.toString(res.constructRectangle(122122)));
    }
}
