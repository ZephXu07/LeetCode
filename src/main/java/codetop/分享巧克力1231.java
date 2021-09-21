package codetop;

import java.util.Random;

/**
 * Title: 分享巧克力1231
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-21
 */
public class 分享巧克力1231 {
    /*
        https://www.cnblogs.com/slowbirdoflsh/p/11738134.html
     */

    public int maximizeSweetness0(int[] sweetness, int K) {
        // sum 该数组总和
        int sum = 0;
        for (int swt : sweetness) {
            sum += swt;
        }

        // avg 如果平均分给K+1个人
        int avg = sum / (K + 1);
        while (avg > 0) {
            // cur 当前分块个数
            // curSum 每个分块的大小
            int cur = 0, curSum = 0;
            for (int swt : sweetness) {
                curSum += swt;
                if (curSum >= avg) {
                    // 从第0块开始切 (cur++ > K or ++cur > (K+1))
                    if (cur++ >= K) {
                        return avg;
                    }
                    curSum = 0;
                }
            }
            // 以步长为1的"速度"向最佳答案靠近
            avg--;
        }

        return avg;
    }



    public int maximizeSweetness1(int[] sweetness, int K) {
        int sum = 0;
        for (int swt : sweetness) {
            sum += swt;
        }

        // ans 返回答案
        // left 二分左值
        // right 二分右值 大小为1e4*1e5
        int left = 0, right = sum / (K + 1);

        // 最佳甜度必定在[left, right]区间内
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            // 检测: 以mid为界限, 大于它的都不可以, 小于等于则可以
            if (check(sweetness, K + 1, mid)) {
                // 最佳mid值在后半段 [mid+1, right]
                left = mid;
            } else {
                // 最佳mid值在前半段 [left, mid-1]
                right = mid - 1;
            }
            /*
                mid 越大，切分的可能越小
                如果 mid 可以，此时所求的答案在 [mid,right] 中
                如果 mid 不可以，此时所求的答案在 [left, mid-1]中
                二分查找右边界
             */
        }

        return left;
    }

    private boolean check(int[] arr, int len, int threshold) {
        // cur 在分块总和满足阈值threshold的情况下 可切块数量 --> k+1
        // sum 单分块之和
        int cur = 0, sum = 0;

        for (int a : arr) {
            sum += a;
            // 该连续块之和符合阈值 予以分块
            if (sum >= threshold) {
                cur++;
                sum = 0;
            }
        }

        // 如果在阈值threshold下 可以分成k+1块 该切割策略符合题意
        return cur >= len;
    }


    public static void main(String[] args) {
        分享巧克力1231 res = new 分享巧克力1231();
        Random r = new Random();
        int len = r.nextInt(100) + 30;
        for (int i = 0; i < len; i++) {
            int[] arr = res.getArr();
            int k = r.nextInt(arr.length);
            long t1 = System.currentTimeMillis();
            int res1 = res.maximizeSweetness0(arr, k);
            long t2 = System.currentTimeMillis();

            long t3 = System.currentTimeMillis();
            int res2 = res.maximizeSweetness1(arr, k);
            long t4 = System.currentTimeMillis();
            System.out.println((t2 - t1) + ":\t" + res1 + "\t" +  (t4 - t3) + ":\t" + res2);
        }
    }

    private int[] getArr () {
        Random r = new Random();
        int len = r.nextInt(10000);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = r.nextInt(100000);
        }
        return res;
    }
}
