package 每日一题;

import java.util.Arrays;

/**
 * Title: 等价多米诺骨牌对的数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-26
 */
public class 等价多米诺骨牌对的数量 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];

        int count = 0;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                int temp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = temp;
            }

            int num = dominoe[0] * 10 + dominoe[1];
            count += freq[num];
            freq[num]++;
        }
        return count;
    }
}
