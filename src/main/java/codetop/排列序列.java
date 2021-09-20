package codetop;

import java.util.LinkedList;

/**
 * Title: 排列序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 排列序列 {
//    public String getPermutation(int n, int k) {
//        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
//        /*
//            题目给了最大范围， i! = factorial[i]
//         */
//        boolean[] visited = new boolean[n + 1];
//        /*
//            记录 [1,n] 中某个数字是否访问了
//         */
//
//        StringBuilder res = new StringBuilder();
//        /*
//            结果
//         */
//
//        for (int i = n - 1; i >= 0; i--) {
//            /*
//                到达了 n - i 层，剩下层排列数
//                为 factorial[i]，直到 n 层
//             */
//            int count = factorial[i];
//
//            for (int j = 1; j <= n; j++) {
//                if (visited[j]) {
//                    /*
//                        当前数字已经访问了，跳过
//                     */
//                    continue;
//                }
//
//                if (k > count) {
//                    /*
//                        当前 n - i 层，剩下的排列数比 k 还小，
//                        证明以 j 固定后剩下的 i 个数字的排列种类小于 k
//                        k 不在 j 此时节点中，
//                        j = j + 1
//                     */
//                    k -= count;
//                    continue;
//                }
//                visited[j] = true;
//                res.append(j);
//                break;
//                /*
//                    以 j 为父节点的子树种类 + [1, j) 的种类超过 k
//                    选择了数字 j
//                    即当前层选择了，
//                    进入下一层 i++, n - i 层
//                 */
//            }
//        }
//        return res.toString();
//        /*
//            n = 4， k = 9
//            此时 n! = 24
//            进入第 n - i 层，i = 3 固定了一个数字
//            选择 1 ，此时 1 与剩下的数排列数有 i! = 3! = 6
//            k > 6
//            所以 j = 1 放弃，k - 6 = 3, 试探 j = 2
//            此时 j = 2  剩下 3 个的数排列数有 i! = 3!= 6
//            k < 6
//            做出选择： 2
//            一个选择后进入下一层，选择了一个数字，再固定一个数字
//            i = 2 , 进入 n - i 层即第 2 层
//            选择 1 ，此时 剩下的 2 个数排列数有 i! = 2! = 2
//            k = 3 > 2
//            所以 j = 1，放弃，k - 2 = 1，试探 j = 2
//            2 被选择了，每层路径不同 1 2 在之前消耗了 k 了，不用减，直接跳过
//            选择 3，此时剩下的 2 个数的排列数有 i! = 2! = 2
//            k = 1 < 2
//            做出选择：3
//            一个选择后进入下一层，选择了一个数字，再固定一个数字
//            i = 1 , 进入 n - i 层即第 3 层
//            选择 1， 此时只有一个数剩下了， i! = 1! = 1
//            k = 1 = 1
//            做出选择 ：1
//            一个选择后进入下一层，选择了一个数字，再固定一个数字
//            i = 0 , 进入 n - i 层即第 4 层
//            1 2 3 都被选择了
//            j = 4 ，剩下 0 个数的排列数也为 1
//            k = 1 = 1
//            做出选择：4
//
//            此时已经到叶子了，结束，返回
//
//
//
//
//         */
//
//
//    }

    public String getPermutation(int n, int k) {
        k--;
        /*
            有序链表中下标是 0 开始的，先自减
         */
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        /*
            题目给了最大范围， i! = factorial[i]
         */

        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.addLast(i);
        }
        /*
            把 [1, n] 添加到有序链表中
         */

        StringBuilder res = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int inx = k / factorial[i];
            res.append(nums.remove(inx));
            k -= inx * factorial[i];
        }
        /*
            有序链表，递增
            如果当前下标为 0
            下标后还有 x个数
            阶乘为 x! = k
            表示 [1, n] 如何排列，其都有 x! 个数，由于是递增，
            所以 x! 个数其实就是最小的 x! == k 个数
            所以当前位填的就是 0 下标上的值
            如
            1 2 3 4
            n = 4, k = 6
            inx = 0, x = 3, x! = 6 = k
            nums[inx] = 1，后面三个数如何排序，
            都将是最小的 k 个数，因为递增，因为 1 是最小的

            如果当前下标为 0
            下标后还有 x个数
            阶乘为 x! < k
            inx = k / x!

            表示 inx - 1 个 x! 的排列的数小于 k ，即这些数都是第 [1， k-1] 的数
            但 第 inx 个 x! 的排列数就包含有第 k 小的数
            所以此时也选择了 nums[inx]，当前 nums[inx]移除
            k 再减去 inx * x! 个数，进入下一个位的计算，

            一直到选择了 n 个数

            0 1 2 3
            1 2 3 4
            n = 4， k = 15
            1 *** = 6
            2 *** = 6
            3 *** = 6
            所以取得 inx = k / 6 = 2 , nums[inx] = 3

            再
            0 1 2
            1 2 4   k = 3
            1 ** = 2
            2 ** = 2
            所以取得 inx = 3 / 2 = 1,nums[inx] = 2

            0 1
            1 4     k = 1
            1 * = 1
            4 * = 1
            inx = 1 / 1 = 1，nums[inx] = 4

            0
            1   k = 0
            0! = 1
            inx = 0 / 1 = 0,nums[inx] = 1
         */

        return res.toString();

    }

    public static void main(String[] args) {
        排列序列 res = new 排列序列();
        System.out.println(res.getPermutation(4, 16));
    }
}
