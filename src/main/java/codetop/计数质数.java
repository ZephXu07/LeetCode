package codetop;

/**
 * Title: 计数质数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-29
 */
public class 计数质数 {
    public int countPrimes(int n) {
        /*
            0 1 以下没有质数
         */
        if (n == 0 || n == 1) {
            return 0;
        }
        boolean[] nums = new boolean[n];
        /*
            是否为质数，false 为质数
         */
        for (int i = 2; i * i < n; i++) {
            /*
                2 是质数，再从没遍历的 3 开始以下操作，如果是 4 ，因为遍历过了，跳过
             */
            if (!nums[i]) {
                /*
                 2 的倍数不是
                 */
                for (int j = i * i; j < n; j += i) {
                    /*
                        4， +2 = 6
                        +2 = 8，直到 n
                     */
                    nums[j] = true;
                    /*
                        true 不是质数
                     */
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                count ++;
            }
            /*
                统计
             */
        }
        return count;
    }
}
