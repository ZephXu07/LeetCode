package codetop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title: IPO
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class IPO {
//    private int res;
//    private int[] Profits;
//    private int[] Capital;
//    private boolean[] visited;
//    private int len;
//    private int k;
//    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//        len = Profits.length;
//        res = 0;
//        visited = new boolean[len];
//        this.Capital = Capital;
//        this.Profits = Profits;
//        this.k = k;
//        dfs(0, W);
//        return res;
//    }
//
//    private void dfs (int count, int cur) {
//        res = Math.max(res, cur);
//        if (count == k || count == len) {
//            return;
//        }
//        for (int i = 0; i < len; i++) {
//            if (visited[i] || cur < Capital[i]) {
//                continue;
//            }
//            visited[i] = true;
//            dfs(count + 1, cur + Profits[i]);
//            visited[i] = false;
//        }
//    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        /*
            银行家算法
            新建数组，对应需要资金与利润
            排序，按需要资金进行排序，从小到大
            k次遍历，最大堆，把需要资金小于等于起始资金的项目的利润加入堆中
            一次进行最大的利润项目，再用此新总利润对下次遍历的项目的启动资本进行遍历
         */
        int len = Profits.length;
        int[][] array = new int[len][2];

        int total = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            array[i][0] = Capital[i];
            array[i][1] = Profits[i];
            max = Math.max(max, Capital[i]);
            total += Profits[i];
        }

        if (k >= len && W >= max) {
            return total + W;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a0, a1)->a1 - a0);

        Arrays.sort(array, Comparator.comparingInt(a -> a[0]));

        int inx = 0;
        int sum = W;
        for (int i = 0; i < k; i++) {
            while (inx < len && array[inx][0] <= sum) {
                maxHeap.offer(array[inx][1]);
                inx++;
            }

            if (!maxHeap.isEmpty()) {
                sum += maxHeap.poll();
                /*
                    因为是遍历k的，所以一次加入一个项目的利润
                 */
            } else {
                /*
                    堆中没有项目，可能是项目遍历完
                    或者当前总利润不足以启动项目
                 */
                break;
            }
        }


        return sum;

    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        System.out.println(ipo.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0,9,10}));
    }

}
