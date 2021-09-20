package 每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 可获得的最大点数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-06
 */
public class 可获得的最大点数 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int size = len - k;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += cardPoints[i];
        }
        int count = sum;
        int min = sum;
        for (int i = size; i < len; i++) {
            sum += cardPoints[i] - cardPoints[i - size];
            count += cardPoints[i];
            min = Math.min(min, sum);
        }
        return count - min;
    }

    public static void main(String[] args) {
        可获得的最大点数 res = new 可获得的最大点数();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(res.maxScore(cardPoints, k));
    }
}
