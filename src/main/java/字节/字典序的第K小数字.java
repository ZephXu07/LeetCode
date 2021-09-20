package 字节;

/**
 * Title: 字典序的第K小数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-18
 */
public class 字典序的第K小数字 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        int prefix = 1;
        while (cur < k) {
            int count = getCount(prefix, n);
            if (cur + count > k) {
                prefix *= 10;
                cur++;
            } else if (cur + count <= k){
                prefix++;
                cur += count;
            }
        }
        return prefix;
    }

    private int getCount(int prefix, int max) {
        int count = 0;
        for (long i = prefix, next = prefix + 1; i <= max; i *= 10, next *= 10) {
            count += Math.min(next, max + 1) - i;
        }
        return count;
    }

    public static void main(String[] args) {
        字典序的第K小数字 res = new 字典序的第K小数字();
        int n = 681692778;
        int k = 351251360;
        System.out.println(res.findKthNumber(n, k));
    }
}
