package 每日一题;

import java.util.Arrays;

/**
 * Title: H指数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-11
 */
public class H指数 {
    public int hIndex(int[] citations) {


        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;

    }

    public static void main(String[] args) {
        H指数 res = new H指数();
//        int[] citations = {3,0,6,1,5};
        int[] citations = {1,3,1};
        System.out.println(res.hIndex(citations));
    }
}
