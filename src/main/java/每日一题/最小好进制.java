package 每日一题;

/**
 * Title: 最小好进制
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-18
 */
public class 最小好进制 {
    public  String smallestGoodBase(String n) {
        //https://leetcode-cn.com/problems/smallest-good-base/solution/zui-xiao-hao-jin-zhi-by-leetcode-solutio-csqn/
        long nVal = Long.parseLong(n);
        // logk(n) = ln(n) / ln(k)
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            //从最大枚举到最小
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            // n = k^0 + k^1 +...+k^m
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }

    public static void main(String[] args) {

    }

}
