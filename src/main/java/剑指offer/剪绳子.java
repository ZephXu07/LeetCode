package 剑指offer;

/**
 * Title: 剪绳子
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 剪绳子 {
    public int cuttingRope(int n) {
        if (0 == n || 1 == n) {
            return 0;
        }
        if (2 == n) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i - j], i - j) * j , dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        剪绳子 res = new 剪绳子();
        System.out.println(res.cuttingRope(0));
        System.out.println(res.cuttingRope(1));
        System.out.println(res.cuttingRope(2));
        System.out.println(res.cuttingRope(3));
        System.out.println(res.cuttingRope(4));
        System.out.println(res.cuttingRope(10));
    }

    public int cuttingRope1(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }
}
