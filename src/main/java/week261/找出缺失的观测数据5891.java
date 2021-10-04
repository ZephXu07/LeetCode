package week261;

/**
 * Title: 找出缺失的观测数据5891
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-03
 */
public class 找出缺失的观测数据5891 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int sum = 0;
        for (int r : rolls) {
            sum += r;
        }
        int total = mean * (len + n);
        int remain = total - sum;
        if (remain > 6 * n || remain < n) {
            return new int[0];
        }

        int avg = remain / n;
        int more = remain % n;

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < more) {
                res[i] = avg + 1;
            } else {
                res[i] = avg;
            }
        }
        return res;
    }
}
