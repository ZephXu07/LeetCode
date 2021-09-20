package codetop;

import java.util.Arrays;

/**
 * Title: 堆箱子
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-20
 */
public class 堆箱子 {
    public int pileBox(int[][] box) {
        /*
            因为要求三个维度均严格递增
            所以哪个维度进行排序都可以
            此刻选择宽度升序，深度和高度降序
            宽度升序是为了寻找其他两个维度的最长上升子序列
            深度和高度在其前面维度相同时降序是为了使最长上升子序列能更长
         */
        Arrays.sort(box, (b1, b2)-> {
            if (b1[0] != b2[0]) {
                return b1[0] - b2[0];
            } else {
                if (b1[1] != b2[1]) {
                    return b2[1] - b1[1];
                } else {
                    return b2[2] - b1[2];
                }
            }
        });

        int len = box.length;
        int[] dp = new int[len];
        /*
            以第 i 个箱子结尾的最高的高度
         */

        dp[0] = box[0][2];
        int res = box[0][2];
        /*
            只有一个箱子时只能选择它
            res 顺便初始化
         */

        for (int i = 1; i < len; i++) {
            int maxHi = 0;
            /*
                最长上升子序列做法
             */
            for (int j = 0; j < i; j++) {
                /*
                    枚举 [0,i-1]，当 i > j 时比较
                    是否能让 [0,i] 的最长上升子序列长度更长
                    此处则是比较第 i 箱子的深度和高度是否大于第 j 箱子
                    是则看是否能更新高度
                    maxHi 是 [0,i - 1] 箱子堆起来的最高高度，
                    dp[j] 是 [0,j] 箱子堆起来的最高高度，不断比较
                 */
                if (box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    maxHi = Math.max(maxHi, dp[j]);
                }
            }
            dp[i] = maxHi + box[i][2];
            /*
                得到 [0,i-1] 的最高高度，再统计自身
             */
            res = Math.max(dp[i], res);
            /*
                比较 [0,len) 的最高高度
             */
        }
        return res;
    }
}
