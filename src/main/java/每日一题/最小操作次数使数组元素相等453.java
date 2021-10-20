package 每日一题;

/**
 * Title: 最小操作次数使数组元素相等453
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-20
 */
public class 最小操作次数使数组元素相等453 {
    public int minMoves(int[] nums) {
        /*
            使 n - 1 个数增加 1 相当于使 1 个数减小 1
            于是寻找最小的，计算每个数减小到最小的次数需要多少
         */
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            min = Math.min(n, min);
        }
        int res = 0;
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }


    public static void main(String[] args) {
        最小操作次数使数组元素相等453 res = new 最小操作次数使数组元素相等453();
//        System.out.println(res.minMoves(new int[]{1, 1000000000}));
//        System.out.println(res.minMoves(new int[]{1,2,3}));
//        System.out.println(res.minMoves(new int[]{1,1,1}));
        System.out.println(res.minMoves(new int[]{1, 1, 1000000000}));
//        System.out.println(res.minMoves(new int[]{-1, 1}));
    }
}
