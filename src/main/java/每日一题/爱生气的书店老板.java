package 每日一题;

/**
 * Title: 爱生气的书店老板
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-23
 */
public class 爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int other = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                other += customers[i];
                customers[i] = 0;
            }
        }
        int left = 0;
        int right = 0;
        int remain = 0;
        int res = 0;
        while (right < len) {
            remain += customers[right];
            right++;
            if (right - left == X)  {
                res = Math.max(res, remain);
                remain -= customers[left];
                left++;
            }
        }
        return res + other;
    }

    public static void main(String[] args) {
        爱生气的书店老板 res = new 爱生气的书店老板();
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int X = 3;
        System.out.println(res.maxSatisfied(customers, grumpy, X));
    }
}
