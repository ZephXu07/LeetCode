package codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Title: 和至少为K的最短子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-22
 */
public class 和至少为K的最短子数组 {
    public int shortestSubarray(int[] nums, int k) {
        /*
            使用前缀和，pre[j]-pre[i] >= k 时使
            j - i 最小
            而如果数组中不存在负数时可以使用滑动窗口解决
            nums.length = len >= j > i
            前缀和是数组长度为 len + 1
            存在负数或0则可能使 pre[j+1] <= pre[j] (j+1<=len)

            res = len + 1，最大的满足结果也只能是 len ，
            而大于 len 表示数组的总和都小于 k
            可以在最后进行一个标识

         1.  假设 i < j，pre[j]-pre[i] >= k (len >= j > i + 1) 时有
            i + 1 < j，pre[i+1] <= pre[i]，即数组中存在负数或者0，
            假设此时 pre[j]-pre[i+1] >= k
            res 明显会取 j - (i+1)
            因为 j-(i+1) < j - i

            所以使用单调栈，保证遍历到 pre[i] 是递增的

            例子  0   1   2    3    4     5
                 56 -21  56   35   -9          k = 61
                 0   56  35   91   134   125

             当固定 j = 4 , pre[j] = 134 时，
             此时有 i = 1   134 - 56 = 78 >= 61  j-i = 4-1=3
             且有  i = 2   134 - 35 = 91 >= 61  j-i = 4-2=2
             明显是取小的，即 56 应该去除

         2.  假设 i < j < len ,且 pre[j]-pre[i]>=k
             如果又有  j+1 <= len，且 pre[j+1]-pre[i] >= k
             res 明显会取 j - i , 因为 (j+1)-i > j-i

             例子  0   1   2    3    4     5
                 56 -21  56   35   -9          k = 61
                 0   56  35   91   134   125

             当固定 i = 1 ，pre[1]=56
             有 j = 4，pre[j]-pre[i]=73>=61       j-i = 4-1=3
             也有 j = 5， pre[j]-pre[i]=69 >= 61  j-i = 5-1=3

             即我们不需要计算 5 - 1= 4 的情况 ，
             即我们找到了 pre[j]-pre[i]>=k，就把 pre[i] 移除了



         */
        long[] pre = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();
        int res = nums.length + 1;

        for (int j = 0; j < pre.length; j++) {
            while (!deque.isEmpty() && pre[j] <= pre[deque.getLast()]) {
                deque.removeLast();
            }

            while (!deque.isEmpty() && pre[j] - pre[deque.getFirst()] >= k) {
                res = Math.min(res, j - deque.removeFirst());
            }

            deque.addLast(j);

        }

        return res > nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        和至少为K的最短子数组 res = new 和至少为K的最短子数组();
        System.out.println(res.shortestSubarray(new int[]{1}, 1) + "\t1");
        System.out.println(res.shortestSubarray(new int[]{1, 2}, 4) + "\t-1");
        System.out.println(res.shortestSubarray(new int[]{2,-1,2}, 3) + "\t3");
        System.out.println(res.shortestSubarray(new int[]{77,19,35,10,-14}, 19) + "\t1");
        System.out.println(res.shortestSubarray(new int[]{56,-21,56,35,-9}, 61) + "\t2");
        System.out.println(res.shortestSubarray(new int[]{-28,81,-20,28,-29}, 89) + "\t3");
    }
}
